package com.corelogic.rps.rentrolldata.amsi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class AMSIServices {
	
	@Autowired
	AMSIGetPropertyList getproperty;
	@Autowired
	AMSIPropertyUnits propertyUnits;
	@Autowired
	AMSIPropertyResidents propertyResidents;
	@Autowired
	AMSIResidents residents;



	
	private static final String fasrclk="fasrclk";
	

	public boolean executeAMSIServices() {
		boolean result =false;
		String propResidentlList="";
		String propertyunits="";
		String residentslist="";
		AMSIInputs inputs=new AMSIInputs();
		inputs.setUrl("http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx");
		inputs.setUsername(fasrclk);
		inputs.setPassword(fasrclk);
		inputs.setPortfolio("esite clk");
		
		String propertylist=getproperty.getPropertyListAMSI(inputs);
		if(propertylist!=null ){
						inputs.setPropertyId("626");
			propertyunits=propertyUnits.getPropertyUnits(inputs);
			propResidentlList=propertyResidents.getPropertyResidents(inputs);
			AMSIInputs inputforresident=new AMSIInputs();
			inputforresident.setUrl("http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx");
			inputforresident.setUsername(fasrclk);
			inputforresident.setPassword(fasrclk);
			inputforresident.setPortfolio("esite clk");
			inputforresident.setPropertyId("626");
			inputforresident.setStartFromDate("04/20/2018");
			inputforresident.setStartToDate("inputforresident");
			inputforresident.setTranFromDate("");
			inputforresident.setTranFromDate("");			
			residentslist=residents.getResidentsByStatusChangeOrTransactionDateForResidents(inputforresident);
			if(log.isInfoEnabled()){
			log.info("propResidentlList"+propResidentlList);
			log.info("propertyunits"+propertyunits);
			log.info("residentslist"+residentslist);
			}

		}
				
		
		
		
		return result;
		
		
	}
}
