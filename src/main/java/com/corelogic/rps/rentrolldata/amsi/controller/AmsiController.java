package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import com.corelogic.rps.rentrolldata.amsi.util.AMSIUtil;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.JsonUtils;
import com.corelogic.rps.rentrolldata.utils.YardiUtils;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.vendordata.service.VendorRequestService;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by 675321 on 2/6/2019.
 */

    @Component
    @Log4j2
    public class AmsiController {
    	private static final String RENTROLL = "RENTROLL";
    	private static final String AMSI = "AMSI";

        @Autowired
        AmsiService amsiservice;
    	@Autowired
    	AuditService auditService;

    	@Autowired
    	private JsonUtils jsonUtils;

    	@Autowired
    	VendorRequestService vendorRequestService;

        @Scheduled(cron = "${amsi.cronExpression}")
        public void getAmsiRentRollData() {

        	log.info("Sheduled job for Yardi Rentroll started");
        	try {
        		List<VendorRequestParams> VendorRequestParamsList = vendorRequestService.getVendorRequestData(AMSI);
        		VendorRequestParamsList.forEach(vendorRequestParams -> {
        			long requestId = auditService.saveRequest(vendorRequestParams.getVendorParamsId().getVendor(),
        					vendorRequestParams.getVendorParamsId().getFurnisher(), RequestStatus.IN_PROGRESS);
        			try {
        				auditService.saveRequestMessage(requestId, "getPropertyListAMSI", RENTROLL, AMSI,
        						jsonUtils.getJsonString(vendorRequestParams), RequestStatus.SUCCESS);

        				String xmlString = null;
        				Document document = null;
        				String xmlsts="";
        				try {
        					xmlString = amsiservice.getPropertyListAMSI(vendorRequestParams.getVendorServiceURL(),vendorRequestParams.getLoginId(),
        							vendorRequestParams.getPasword(), 	vendorRequestParams.getEntity()
        							);
        					auditService.saveRequestMessage(requestId, "getPropertyListAMSI", AMSI, RENTROLL,
        							xmlString, RequestStatus.SUCCESS);
        				} catch (Exception e) {
        					auditService.saveRequestMessage(requestId, "getPropertyListAMSI", AMSI, RENTROLL,
        							e.getMessage(), RequestStatus.FAILED);
        					auditService.updateRequest(requestId, RequestStatus.FAILED);
        				}
        				document=AMSIUtil.convertStringToDocument(xmlString);
        				Node node = document.getDocumentElement();
        				NodeList nodeList = node.getChildNodes();
        				for (int i = 0; i < nodeList.getLength(); i++) {
        					Node currentNode = nodeList.item(i);
        					if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
        						Element el = (Element) currentNode;
        						String prop = el.getElementsByTagName("PropertyId").item(0).getTextContent();
        						if (StringUtils.isNotBlank(prop)) {

        							//getPropertyUnits
        							auditService.saveRequestMessage(requestId, "getPropertyUnits", RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + "Property:" + prop,
        									RequestStatus.SUCCESS);    								
        							try {
        								xmlsts = amsiservice.getPropertyUnits(vendorRequestParams.getVendorServiceURL(), vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getEntity(), prop);

        								auditService.saveRequestMessage(requestId, "getPropertyUnits", AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, "getPropertyUnits", AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        							}

        							//getPropertyResidents
        							auditService.saveRequestMessage(requestId, "getPropertyResidents", RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + "Property:" + prop,
        									RequestStatus.SUCCESS);    								
        							try {
        								xmlsts = amsiservice.getPropertyResidents(vendorRequestParams.getVendorServiceURL(), vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getEntity(), prop);

        								auditService.saveRequestMessage(requestId, "getPropertyResidents", AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, "getPropertyResidents", AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        							}

        							//getResidentsByStatusChangeOrTransactionDateForResidents
        							auditService.saveRequestMessage(requestId, "getResidentsByStatusChangeOrTransactionDateForResidents", RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + "Property:" + prop,
        									RequestStatus.SUCCESS);    								
        							try {
        								xmlsts = amsiservice.getResidentsByStatusChangeOrTransactionDateForResidents(vendorRequestParams.getVendorServiceURL(), vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getEntity(), prop);

        								auditService.saveRequestMessage(requestId, "getResidentsByStatusChangeOrTransactionDateForResidents", AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, "getResidentsByStatusChangeOrTransactionDateForResidents", AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        							}

        						}
        					}
        				}
        			} catch (Exception ex) {
        				if (log.isInfoEnabled()) {
        					log.info("Error retrieving rent Yardi roll data for the furnisher ID"
        							, vendorRequestParams.getVendorParamsId().getFurnisher(), "error","message");
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
