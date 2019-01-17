package com.corelogic.rps.rentroll.services;


import java.net.URL;
import java.rmi.RemoteException;

import org.tempuri.LeasingLocator;
import org.tempuri.LeasingSoap;

import lombok.extern.log4j.Log4j2;
@Log4j2

public class AMSIPropertys {

	
    public static final String AMSI_SERVICES = "http://tempuri.org/";
 //   private static String Url ="http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx";   
    private static String PNAME ="esite clk";
    
    public  static String getPropertyListAMSI(String userID,
        String userPassword, String propid, String url) throws RemoteException {
    	String result="";
        LeasingLocator Service = new LeasingLocator();
        LeasingSoap query;

        try {

        	URL urladdress = new URL(url);        	
        	query = Service.getLeasingSoap(urladdress);
        	result=query.getPropertyList(userID, userPassword,PNAME,"");
        	log.info(result);
        }catch (Exception e) {
        	log.info("Excpetion", e);
              }
        
				return result;
    	
    	
    }
}
