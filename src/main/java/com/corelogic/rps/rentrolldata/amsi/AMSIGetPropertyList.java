package com.corelogic.rps.rentrolldata.amsi;

import java.net.MalformedURLException;
import java.net.URL;


import com.corelogic.rps.rentrolldata.amsi.generated.Leasing;
import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;

import lombok.extern.log4j.Log4j2;
@Log4j2

public class AMSIGetPropertyList {
	

	Leasing leasing=new Leasing();
	private static String url="http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx";
	
	public String  getPropertyListAMSI() throws MalformedURLException{
		
		String result="";
		try {
		URL urladdress = new URL(url);
		 LeasingSoap port = getProxy(urladdress);
		//LeasingSoap leasesoap=leasing.getLeasingSoap();
		result=port.getPropertyList("fasrclk", "fasrclk", "esite clk", "");
		
		log.info("result"+result);
		}catch(MalformedURLException e){
			
		}
		
		return result;	

		
	}
	
    private  LeasingSoap getProxy(URL Urllcl){
    	LeasingSoap leasesoap=leasing.getLeasingSoap();

                        return leasesoap;
            }
	
	

}
