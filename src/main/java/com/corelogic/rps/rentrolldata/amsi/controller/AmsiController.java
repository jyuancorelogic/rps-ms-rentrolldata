package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import com.corelogic.rps.rentrolldata.amsi.util.AMSIUtil;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.JsonUtils;
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
       	private static final String GET_PROPERTY_LIST="getPropertyListAMSI";
       	private static final String GET_PROPERTY_UNITS="getPropertyUnits";	
      	private static final String GET_PROPERTY_RESIDENTS="getPropertyResidents";
       	private static final String GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE="getResidentsByStatusChangeOrTransactionDateForResidents";
       	private static final String GET_PROPERTY_RESIDENTS_BY_TRAN_DATE="getResidentsByStatusTransactionDateForResidents";
       	private static final String PROPERTY="Property:";

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

        	log.info("Sheduled job for AMSI Rentroll started");
        	try {
        		List<VendorRequestParams> vendorRequestParamsList = vendorRequestService.getVendorRequestData(AMSI);
        		vendorRequestParamsList.forEach(vendorRequestParams -> {
        			long requestId = auditService.saveRequest(vendorRequestParams.getVendorParamsId().getVendor(),
        					vendorRequestParams.getVendorParamsId().getFurnisher(), RequestStatus.IN_PROGRESS);
        			try {
        				auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, RENTROLL, AMSI,
        						jsonUtils.getJsonString(vendorRequestParams), RequestStatus.SUCCESS);

        				String xmlString = null;
        				Document document = null;
        				String xmlsts="";
        				try {
        					xmlString = amsiservice.getPropertyListAMSI(vendorRequestParams.getLoginId(),
        							vendorRequestParams.getPasword(), 	vendorRequestParams.getVendorDatabase()
        							);
        					auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, AMSI, RENTROLL,
        							xmlString, RequestStatus.SUCCESS);
        				} catch (Exception e) {
        					auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, AMSI, RENTROLL,
        							e.getMessage(), RequestStatus.FAILED);
        					auditService.updateRequest(requestId, RequestStatus.FAILED);
        					log.error("Exception in GET_PROPERTY_LIST ", e);
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

        							auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + prop,
        									RequestStatus.SUCCESS);    								
        							try {
        								xmlsts = amsiservice.getPropertyUnits( vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), prop);

        								auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        	        						log.error("Exception in GET_PROPERTY_UNITS ", e);

        							}
        							auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + prop,
        									RequestStatus.SUCCESS);    								
        							try {
        								xmlsts = amsiservice.getPropertyResidents( vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), prop);

        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);          	        					
        	        						log.error("Exception in GET_PROPERTY_RESIDENTS ", e);
        	        					
        							}

        							auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + prop,
        									RequestStatus.SUCCESS);  
        							auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, RENTROLL, AMSI,
        									jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + prop,
        									RequestStatus.SUCCESS);
        							try {
        								xmlsts = amsiservice.getResidentsByStatusChangeOrTransactionDateForResidents( vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), prop);

        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        								xmlsts = amsiservice.getResidentsByStatusTransactionDateForResidents( vendorRequestParams.getLoginId(),
        										vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), prop);

        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, AMSI,
        										RENTROLL, xmlsts, RequestStatus.SUCCESS);
        							} catch (Exception e) {
        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        								auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, AMSI,
        										RENTROLL, e.getMessage(), RequestStatus.FAILED);
        								auditService.updateRequest(requestId, RequestStatus.FAILED);
        								
        	        						log.error("Exception in GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE ", e);
        	        					
        							}

        						}
        					}
        				}
        			} catch (Exception ex) {
        					log.error("Error retrieving amsi rent roll data", ex);
        				auditService.updateRequest(requestId, RequestStatus.FAILED);
        			}
        		});
        	} catch (Exception e) {
        		log.error("Error running the AMSI Sheduled job", e);
        	}




        }
    }
