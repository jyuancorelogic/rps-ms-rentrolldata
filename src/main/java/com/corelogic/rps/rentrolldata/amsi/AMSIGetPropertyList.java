package com.corelogic.rps.rentrolldata.amsi;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;

import lombok.extern.log4j.Log4j2;
@Log4j2

@Component
public class AMSIGetPropertyList {
	   
	
   public String  getPropertyListAMSI(AMSIInputs inputs) {			
		   String result="";
		   try {
			   log.info(inputs.getUrl());
			   URL urladdress = new URL(inputs.getUrl());
			   LeasingSoap port = AMSIUtil.getProxy(urladdress);
			   result=port.getPropertyList(inputs.getUsername(), inputs.getPassword(), inputs.getPortfolio(), "");
				if(log.isInfoEnabled()){
				   log.info("result"+result);
			   }
		   }catch(MalformedURLException e){
				if(log.isInfoEnabled()){
				   log.info("MalformedURLException"+e);
				   }

		   }

		   return result;	


	   }
	
   
	

}
