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


    @Value("${amsi.endpoint}")
    private String url;

    @Value("${amsi.username}")
    private String username;

    @Value("${amsi.password}")
    private String password;

    @Value("${amsi.portfolio}")
    private String portfolio;

    public static final String MalformedURLException="MalformedURLException";
  

    public boolean executeAMSIServices() {
        boolean result = false;
        String propertylist = getPropertyListAMSI();
        if (propertylist != null) {
            String propertId="626";
             getPropertyUnits(propertId);
             getPropertyResidents(propertId);
          getResidentsByStatusChangeOrTransactionDateForResidents(propertId);
          result= true;
        }

        return result;

    }


    public String getPropertyListAMSI() {
        String result = "";
        try {
            log.info(url);
            URL urlAddress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urlAddress);
            result = port.getPropertyList(username,password, portfolio, "");
                      if (log.isInfoEnabled()) {
                log.info("getPropertyListAMSI" + result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
                log.info(MalformedURLException + e);
            }

        }
        return result;
    }


    public void getPropertyResidents(String propertyId) {
        String result = "";
        try {
            URL urladdress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urladdress);
            String proprequest = AMSIUtil.processHR(propertyId);
            result = port.getPropertyResidents(username,password, portfolio, proprequest);
            if (log.isInfoEnabled()) {
                log.info("getPropertyResidents" + result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
                log.info(MalformedURLException + e);
            }
        }

    }

    public void getPropertyUnits(String propertyId) {
        String result = "";
        try {
            URL urladdress = new URL(url);
            LeasingSoap port = AMSIUtil.getProxy(urladdress);
            String proprequest = AMSIUtil.processHR(propertyId);
            result = port.getPropertyUnits(username, password, portfolio, proprequest);
            if (log.isInfoEnabled()) {
                log.info("getPropertyUnits" + result);
            }
        } catch (MalformedURLException e) {
            if (log.isInfoEnabled()) {
                log.info(MalformedURLException + e);
            }

        }
    }
    public void getResidentsByStatusChangeOrTransactionDateForResidents(String propertyId) {
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
    			log.info("getResidentsByStatusChangeOrTransactionDateForResidents" + result+"result2"+result2);
    		}
    	} catch (MalformedURLException e) {
    		if (log.isInfoEnabled()) {
    			log.info(MalformedURLException + e);
    		}

    	}
    }

        public void getResidentsByStatusChangeOrTransactionDateForClients(String propertyId) {
            String result = "";
            try {
                URL urladdress = new URL(url);
                LeasingSoap port = AMSIUtil.getProxy(urladdress);
                String proprequest = AMSIUtil.processHR(propertyId);
                result = port.getResidentsByStatusChangeOrTransactionDate(username, password,
                        portfolio, proprequest);
                if (log.isInfoEnabled()) {
                    log.info("getResidentsByStatusChangeOrTransactionDateForClients" + result);
                }
            } catch (MalformedURLException e) {
                if (log.isInfoEnabled()) {
                    log.info(MalformedURLException + e);
                }

            }
        }




}

