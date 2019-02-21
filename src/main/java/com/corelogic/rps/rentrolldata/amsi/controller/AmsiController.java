package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import com.corelogic.rps.rentrolldata.amsi.util.AMSIUtil;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.JsonUtils;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.vendordata.service.VendorRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;

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
        public void getAmsiRentRollData() throws JsonProcessingException {
        	log.info("Sheduled job for AMSI Rentroll started");
        	List<VendorRequestParams> vendorRequestParamsList = vendorRequestService.getVendorRequestData(AMSI);
        	try{
        		vendorRequestParamsList.forEach(vendorRequestParams -> {
        			long requestId = auditService.saveRequest(vendorRequestParams.getVendorParamsId().getVendor(),vendorRequestParams.getVendorParamsId().getFurnisher(), RequestStatus.IN_PROGRESS);
        			try {
        				String xmlString=getPropertyList(requestId,vendorRequestParams);
        				Document	document=AMSIUtil.convertStringToDocument(xmlString);
        				Node node = document.getDocumentElement();
        				NodeList nodeList = node.getChildNodes();
        				for (int i = 0; i < nodeList.getLength(); i++) {
        					Node currentNode = nodeList.item(i);
        					if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
        						Element el = (Element) currentNode;
        						String prop = el.getElementsByTagName("PropertyId").item(0).getTextContent();
        						if (StringUtils.isNotBlank(prop)) {
        							getPropertyUnits(requestId,prop,vendorRequestParams);
        							getPropertyResidents(requestId,prop,vendorRequestParams);
        							getResidentsByStatusChangeOrTransactionDateForResidents(requestId,prop,vendorRequestParams);						
        						}
        					}
        				}
        			} catch (Exception ex) {
        				log.error("Error retrieving amsi rent roll data", ex);
        				auditService.updateRequest(requestId, RequestStatus.FAILED);
        			}
        		});
        	}catch (Exception e) {
    			log.error("Error running the AMSI Sheduled job", e);
    		}

        }
        
        private String  getPropertyList(long requestId,VendorRequestParams vendorRequestParams) throws JsonProcessingException{
        	auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, RENTROLL, AMSI,jsonUtils.getJsonString(vendorRequestParams), RequestStatus.SUCCESS);
			String xmlString = "";
			
			try {
				xmlString = amsiservice.getPropertyListAMSI(vendorRequestParams.getLoginId(), vendorRequestParams.getPasword(),vendorRequestParams.getVendorDatabase());
				auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, AMSI, RENTROLL,xmlString, RequestStatus.SUCCESS);
			} catch (Exception e) {
				auditService.saveRequestMessage(requestId, GET_PROPERTY_LIST, AMSI, RENTROLL,e.getMessage(), RequestStatus.FAILED);
				auditService.updateRequest(requestId, RequestStatus.FAILED);
				log.error("Exception in GET_PROPERTY_LIST ", e);
				throw e;
			}
        	
			return xmlString;
        	
        }
        
        private void  getPropertyUnits(long requestId, String propertyId, VendorRequestParams vendorRequestParams) throws JsonProcessingException{
        	
        	auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, RENTROLL, AMSI,jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + propertyId,RequestStatus.SUCCESS);    								
			try {
				String xmlStr = amsiservice.getPropertyUnits( vendorRequestParams.getLoginId(),vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), propertyId);

				auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, AMSI,RENTROLL, xmlStr, RequestStatus.SUCCESS);
			} catch (Exception e) {
				auditService.saveRequestMessage(requestId, GET_PROPERTY_UNITS, AMSI,RENTROLL, e.getMessage(), RequestStatus.FAILED);
				auditService.updateRequest(requestId, RequestStatus.FAILED);
					log.error("Exception in GET_PROPERTY_UNITS ", e);
					throw e;
			} 
        	
        }
        
        private void  getPropertyResidents(long requestId, String propertyId, VendorRequestParams vendorRequestParams) throws JsonProcessingException{

        	auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, RENTROLL, AMSI,jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + propertyId,
					RequestStatus.SUCCESS);    								
			try {
				String xmlStr = amsiservice.getPropertyResidents( vendorRequestParams.getLoginId(),vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), propertyId);
				auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, AMSI,RENTROLL, xmlStr, RequestStatus.SUCCESS);
			} catch (Exception e) {
				auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS, AMSI,RENTROLL, e.getMessage(), RequestStatus.FAILED);
				auditService.updateRequest(requestId, RequestStatus.FAILED);          	        					
				log.error("Exception in GET_PROPERTY_RESIDENTS ", e);
				throw e;

			}
        }
        
        private void  getResidentsByStatusChangeOrTransactionDateForResidents(long requestId, String propertyId, VendorRequestParams vendorRequestParams) throws JsonProcessingException{
        	auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, RENTROLL, AMSI,jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + propertyId,RequestStatus.SUCCESS);  
        	auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, RENTROLL, AMSI,jsonUtils.getJsonString(vendorRequestParams) + PROPERTY + propertyId,RequestStatus.SUCCESS);
        	try {
        		String xmlStr = amsiservice.getResidentsByStatusChangeOrTransactionDateForResidents( vendorRequestParams.getLoginId(),vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), propertyId);

        		auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, AMSI,RENTROLL, xmlStr, RequestStatus.SUCCESS);
        		String xmlStrRes = amsiservice.getResidentsByStatusTransactionDateForResidents( vendorRequestParams.getLoginId(),vendorRequestParams.getPasword(), vendorRequestParams.getVendorDatabase(), propertyId);

        		auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, AMSI,RENTROLL, xmlStrRes, RequestStatus.SUCCESS);
        	} catch (Exception e) {
        		auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE, AMSI,RENTROLL, e.getMessage(), RequestStatus.FAILED);
        		auditService.updateRequest(requestId, RequestStatus.FAILED);
        		auditService.saveRequestMessage(requestId, GET_PROPERTY_RESIDENTS_BY_TRAN_DATE, AMSI,RENTROLL, e.getMessage(), RequestStatus.FAILED);
        		auditService.updateRequest(requestId, RequestStatus.FAILED);        								
        		log.error("Exception in GET_PROPERTY_RESIDENTS_BY_STATUS_CHANGE_TRAN_DATE ", e);
        		throw e;

        	}

        }
    }
