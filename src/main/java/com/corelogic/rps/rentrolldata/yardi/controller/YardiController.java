package com.corelogic.rps.rentrolldata.yardi.controller;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.JsonUtils;
import com.corelogic.rps.rentrolldata.utils.YardiUtils;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.vendordata.service.VendorRequestService;
import com.corelogic.rps.rentrolldata.yardi.service.YardiService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class YardiController {

	@Autowired
	YardiService yardiService;

	@Autowired
	AuditService auditService;

	@Autowired
	private JsonUtils jsonUtils;

	@Autowired
	VendorRequestService vendorRequestService;

	private static final String RENTROLL = "RENTROLL";
	private static final String YARDI = "YARDI";
	private static final String GET_PROPERTY_CONFIGURATIONS = "getPropertyConfigurations";
	private static final String GET_UNIT_CONFIGURATIONS = "getUnitConfiguration";

	@Scheduled(cron = "${yardi.cronExpression}")
	public void getYardiRentRollData() {
		log.info("Sheduled job for Yardi Rentroll started");
		try {
			List<VendorRequestParams> VendorRequestParamsList = vendorRequestService.getVendorRequestData(YARDI);
			VendorRequestParamsList.forEach(vendorRequestParams -> {
				long requestId = auditService.saveRequest(vendorRequestParams.getVendorParamsId().getVendor(),
						vendorRequestParams.getVendorParamsId().getFurnisher(), RequestStatus.IN_PROGRESS);
				try {
					auditService.saveRequestMessage(requestId, GET_PROPERTY_CONFIGURATIONS, RENTROLL, YARDI,
							jsonUtils.getJsonString(vendorRequestParams), RequestStatus.SUCCESS);
					Document document = null;
					String xmlString = null;
					try {
						document = yardiService.getYardiProperties(vendorRequestParams.getLoginId(),
								vendorRequestParams.getPasword(), vendorRequestParams.getServer(),
								vendorRequestParams.getVendorDatabase(), vendorRequestParams.getPlatform(),
								vendorRequestParams.getEntity(), vendorRequestParams.getLicence(),
								vendorRequestParams.getVendorServiceURL());
						xmlString = YardiUtils.convertDocumentToString(document);
						auditService.saveRequestMessage(requestId, GET_PROPERTY_CONFIGURATIONS, YARDI, RENTROLL,
								xmlString, RequestStatus.SUCCESS);
					} catch (Exception e) {
						auditService.saveRequestMessage(requestId, GET_PROPERTY_CONFIGURATIONS, YARDI, RENTROLL,
								e.getMessage(), RequestStatus.FAILED);
						auditService.updateRequest(requestId, RequestStatus.FAILED);				
    						log.error("Exception in GET_PROPERTY_CONFIGURATIONS ", e);
    				
					}
					Node node = document.getDocumentElement();
					NodeList nodeList = node.getChildNodes();
					for (int i = 0; i < nodeList.getLength(); i++) {
						Node currentNode = nodeList.item(i);
						if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
							Element el = (Element) currentNode;
							String prop = el.getElementsByTagName("Code").item(0).getTextContent();
							if (StringUtils.isNotBlank(prop)) {
								auditService.saveRequestMessage(requestId, GET_UNIT_CONFIGURATIONS, RENTROLL, YARDI,
										jsonUtils.getJsonString(vendorRequestParams) + "Property:" + prop,
										RequestStatus.SUCCESS);
								try {
									document = yardiService.getYardiUnitConfiguration(vendorRequestParams.getLoginId(),
											vendorRequestParams.getPasword(), vendorRequestParams.getServer(),
											vendorRequestParams.getVendorDatabase(), vendorRequestParams.getPlatform(),
											vendorRequestParams.getEntity(), vendorRequestParams.getLicence(),
											vendorRequestParams.getVendorServiceURL(), prop);
									String propXmlString = YardiUtils.convertDocumentToString(document);
									auditService.saveRequestMessage(requestId, GET_UNIT_CONFIGURATIONS, YARDI,
											RENTROLL, propXmlString, RequestStatus.SUCCESS);
								} catch (Exception e) {
									auditService.saveRequestMessage(requestId, GET_UNIT_CONFIGURATIONS, YARDI,
											RENTROLL, e.getMessage(), RequestStatus.FAILED);
									auditService.updateRequest(requestId, RequestStatus.FAILED);									
			    						log.error("Exception in GET_UNIT_CONFIGURATIONS ", e);
									
								}
							}
						}
					}
				} catch (Exception ex) {
					if (log.isInfoEnabled()) {
						log.info("Error retrieving rent Yardi roll data for the furnisher ID"
								, vendorRequestParams.getVendorParamsId().getFurnisher(), ex,"message");
					}
					auditService.updateRequest(requestId, RequestStatus.FAILED);
				}
			});
		} catch (Exception e) {
			log.error("Error running the Yardi Sheduled job", e);
		}
		log.info("Sheduled job for Yardi Rentroll ended");
	}
}
