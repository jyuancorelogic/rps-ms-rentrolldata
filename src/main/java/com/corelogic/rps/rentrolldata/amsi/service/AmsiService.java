package com.corelogic.rps.rentrolldata.amsi.service;


import com.corelogic.rps.rentrolldata.amsi.util.AMSIUtil;
import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 675321 on 2/6/2019.
 */
@Log4j2
@Service
public class AmsiService {





    public String getPropertyListAMSI(String url, String username, String password,String portfolio ) {
        String result = "";
        try {
            log.info(url);
            URL urlAddress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urlAddress);
            result = port.getPropertyList(username,password, portfolio, "");
                      if (log.isInfoEnabled()) {
                log.info("getPropertyListAMSI", result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
                log.info("MalformedURLException in getPropertyListAMSI", e);
            }

        }
        return result;
    }


    public String getPropertyResidents(String url, String username, String password,String portfolio, String propertyId) {
        String result = "";
        try {
            URL urladdress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urladdress);
            String proprequest = AMSIUtil.processHR(propertyId);
            result = port.getPropertyResidents(username,password, portfolio, proprequest);
            if (log.isInfoEnabled()) {
                log.info("getPropertyResidents", result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
                log.info("MalformedURLException in getPropertyResidents", e);
            }
        }
        return result;

    }

    public String getPropertyUnits(String url, String username, String password,String portfolio , String propertyId) {
        String result = "";
        try {
            URL urladdress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urladdress);
            String proprequest = AMSIUtil.processHR(propertyId);
            result = port.getPropertyUnits(username, password, portfolio, proprequest);
            if (log.isInfoEnabled()) {
                log.info("getPropertyUnits" , result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
            	 log.info("Exception in getPropertyUnits ", e);
            }

        }
        return result;
    }
    public String  getResidentsByStatusChangeOrTransactionDateForResidents(String url, String username, String password,String portfolio ,String propertyId) {
    	String result="";
    	String result2 = "";
    	try {
    		URL urladdress = new URL(url);
    		LeasingSoap port = AMSIUtil.getProxy(urladdress);
    		String proprequestStart = AMSIUtil.processHR(propertyId,"04/20/2010",
    				"04/21/2010","", "");
    		String proprequesttran = AMSIUtil.processHR(propertyId,"",
    				"","04/22/2010", "04/23/2010");
    		result = port.getResidentsByStatusChangeOrTransactionDate(username, password,
    				portfolio, proprequestStart);
    		result2 = port.getResidentsByStatusChangeOrTransactionDate(username, password,
    				portfolio, proprequesttran);
    		if (log.isInfoEnabled()) {
    			log.info("getResidentsByStatusChangeOrTransactionDateForResidents" ,  result);
    			log.info("result2",result2);
    		}
    	} catch (MalformedURLException e) {
    		if (log.isInfoEnabled()) {
    			 log.info("MalformedURLException", e);
    		}

    	}
    	return result;
    }

        public String  getResidentsByStatusChangeOrTransactionDateForClients(String url, String username, String password,String portfolio ,String propertyId) {
            String result = "";
            try {
                URL urladdress = new URL(url);
                LeasingSoap port = AMSIUtil.getProxy(urladdress);
                String proprequest = AMSIUtil.processHR(propertyId);
                result = port.getResidentsByStatusChangeOrTransactionDate(username, password,
                        portfolio, proprequest);
                if (log.isInfoEnabled()) {
                    log.info("getResidentsByStatusChangeOrTransactionDateForClients" ,  result);
                }
            } catch (MalformedURLException e) {
                if (log.isInfoEnabled()) {
                	 log.info("MalformedURLException", e);
                }

            }
            return result;
        }




}

