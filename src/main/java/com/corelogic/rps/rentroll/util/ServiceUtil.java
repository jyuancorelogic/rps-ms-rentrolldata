package com.corelogic.rps.rentroll.util;

import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.xml.rpc.ServiceException;

import org.tempuri.LeasingLocator;
import org.tempuri.LeasingSoap;
import org.tempuri.LeasingSoapStub;

public class ServiceUtil {
	
    private static String USER = "fasrclk";
    private static String PASSWORD = "fasrclk";
	
    public static String processHR(String PID) throws SQLException {

    	StringBuffer requeststring= new StringBuffer();
               requeststring.append("<EDEX><EDEX><propertyid>");
               requeststring.append(PID.trim() + "</propertyid></EDEX></EDEX>");               
               return requeststring.toString();

        }
    
    @SuppressWarnings("unused")
	private static LeasingSoap getProxy(java.net.URL Urllcl) throws MalformedURLException, ServiceException{

    	LeasingLocator locator = new LeasingLocator();
    	LeasingSoap result = locator.getLeasingSoap(Urllcl);
    	LeasingSoapStub stub = (LeasingSoapStub) result;
    	stub.setUsername(USER);
    	stub.setPassword(PASSWORD);
    	return result;
    }


}
