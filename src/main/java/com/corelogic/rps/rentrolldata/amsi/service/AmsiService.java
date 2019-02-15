package com.corelogic.rps.rentrolldata.amsi.service;


import com.corelogic.rps.rentrolldata.amsi.util.AMSIUtil;
import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;


import org.springframework.stereotype.Service;


/**
 * Created by 675321 on 2/6/2019.
 */

@Service
public class AmsiService {





	public String getPropertyListAMSI(String username, String password,String portfolio ) {
		String result = "";    

		LeasingSoap port = AMSIUtil.getProxy();
		result = port.getPropertyList(username,password, portfolio, "");

		return result;
	}


	public String getPropertyResidents( String username, String password,String portfolio, String propertyId) {
		String result = "";

		LeasingSoap port = AMSIUtil.getProxy();
		String proprequest = AMSIUtil.processHR(propertyId);
		result = port.getPropertyResidents(username,password, portfolio, proprequest);
		return result;

	}

    public String getPropertyUnits( String username, String password,String portfolio , String propertyId) {
        String result = "";
            LeasingSoap port = AMSIUtil.getProxy();
            String proprequest = AMSIUtil.processHR(propertyId);
            result = port.getPropertyUnits(username, password, portfolio, proprequest);


        return result;
    }
    public String  getResidentsByStatusChangeOrTransactionDateForResidents( String username, String password,String portfolio ,String propertyId) {
    	String result="";
   // 	String result2 = "";
    
    		LeasingSoap port = AMSIUtil.getProxy();
    		String proprequestStart = AMSIUtil.processHR(propertyId,"04/20/2010",
    				"04/21/2010","", "");
    		String proprequesttran = AMSIUtil.processHR(propertyId,"",
    				"","04/22/2010", "04/23/2010");
    		result = port.getResidentsByStatusChangeOrTransactionDate(username, password,
    				portfolio, proprequestStart);
    //		result2 = port.getResidentsByStatusChangeOrTransactionDate(username, password,
    	//			portfolio, proprequesttran);
    	return result;
    }

        public String  getResidentsByStatusChangeOrTransactionDateForClients(String username, String password,String portfolio ,String propertyId) {
            String result = "";      

                LeasingSoap port = AMSIUtil.getProxy();
                String proprequest = AMSIUtil.processHR(propertyId);
                result = port.getResidentsByStatusChangeOrTransactionDate(username, password,
                        portfolio, proprequest);
            return result;
        }




}

