package com.corelogic.rps.rentrolldata.amsi.util;

import java.io.IOException;
import java.io.StringReader;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.corelogic.rps.rentrolldata.amsi.generated.Leasing;
import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;


import lombok.extern.log4j.Log4j2;
@Log4j2
public final class AMSIUtil {

	private   AMSIUtil() {
		throw new IllegalStateException("Utility class");
	}
	public static LeasingSoap getProxy() {
		Leasing leasing = new Leasing();
		return leasing.getLeasingSoap();
	}

	public static String processHR(String pid) {

		StringBuilder requeststring = new StringBuilder(52);
		requeststring.append("<EDEX><EDEX><propertyid>").append( pid.trim())
		.append("</propertyid></EDEX></EDEX>");
		return requeststring.toString();

	}

	public static String processHR(String pid, String statfrmdt, String stattodt, String tranfrmdt, String trantodt) {
		StringBuilder requeststring = new StringBuilder(219);
		requeststring.append("<EDEX><EDEX><propertyid>").append(pid.trim())
				.append("</propertyid><statuschangedatefrom>").append(statfrmdt)
				.append("</statuschangedatefrom><statuschangedateto>").append(stattodt)
				.append("</statuschangedateto><transactiondatefrom>").append(tranfrmdt)
				.append("</transactiondatefrom><transactiondateto>").append(trantodt)
				.append("</transactiondateto></EDEX></EDEX>");

		return requeststring.toString();

	}
	
	public static Document convertStringToDocument(String xmlStr) {


			DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
			Document doc=null;
			try {
				db.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
				DocumentBuilder dbf = db.newDocumentBuilder();
				doc = dbf.parse( new InputSource( new StringReader( xmlStr ) ) );
			} catch (ParserConfigurationException e) {
				log.error("ParserConfigurationException", e);
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				log.error("Exception", e);
			} 
 
		return doc;
	}

}
