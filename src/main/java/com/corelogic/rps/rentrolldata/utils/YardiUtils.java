package com.corelogic.rps.rentrolldata.utils;

import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30;
import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class YardiUtils {

	public static ItfRentersInsurance30Soap getProxy() {
		ItfRentersInsurance30 service = new ItfRentersInsurance30();
		return service.getItfRentersInsurance30Soap();
	}

	public static String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			return writer.getBuffer().toString();
			 
		} catch (TransformerException e) {
			if (log.isInfoEnabled()) {
                log.info("TransformerException" + e);
            }

		}

		return null;
	}

}
