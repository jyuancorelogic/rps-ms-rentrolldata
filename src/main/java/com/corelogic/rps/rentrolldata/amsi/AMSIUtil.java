package com.corelogic.rps.rentrolldata.amsi;

import java.net.URL;

import com.corelogic.rps.rentrolldata.amsi.generated.Leasing;
import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;

public class AMSIUtil {

	public static LeasingSoap getProxy(URL Urllcl) {
		Leasing leasing = new Leasing();
		return leasing.getLeasingSoap();
	}

	public static String processHR(String PID) {

		StringBuffer requeststring = new StringBuffer(52);
		requeststring.append("<EDEX><EDEX><propertyid>" + PID.trim() + "</propertyid></EDEX></EDEX>");
		return requeststring.toString();

	}

	public static String processHR(String PID, String statfrmdt, String stattodt, String tranfrmdt, String trantodt) {
		StringBuffer requeststring = new StringBuffer(219);
		requeststring.append("<EDEX><EDEX><propertyid>").append(PID.trim())
				.append("</propertyid><statuschangedatefrom>").append(statfrmdt)
				.append("</statuschangedatefrom><statuschangedateto>").append(stattodt)
				.append("</statuschangedateto><transactiondatefrom>").append(tranfrmdt)
				.append("</transactiondatefrom><transactiondateto>").append(trantodt)
				.append("</transactiondateto></EDEX></EDEX>");

		return requeststring.toString();

	}

}
