package com.corelogic.rps.rentrolldata.utils;

import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * Created by 675321 on 2/11/2019.
 */
public class YardiUtilsTest {

    @Test
    public void testGetProxy() throws Exception {
        ItfRentersInsurance30Soap result = YardiUtils.getProxy();
        Assert.assertNotNull(result);    
       
    }

    @Test
    public void testConvertDocumentToString() throws Exception {
    	String result = YardiUtils.convertDocumentToString(null);
    	Assert.assertNotNull(result);  

    }
    
    @Test
    public void testConvertDocumentToString2() throws Exception {
    	Document document = null;
    	String xml="<TEST>#345</TEST>";
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	document= builder.parse(new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
    	String result = YardiUtils.convertDocumentToString(document);
    	Assert.assertNotNull(result);  

    }
    

}

