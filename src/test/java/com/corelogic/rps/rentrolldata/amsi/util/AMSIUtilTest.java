package com.corelogic.rps.rentrolldata.amsi.util;


import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;


import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;
/**
 * Created by 675321 on 2/13/2019.
 */
public class AMSIUtilTest {

    @Test
    public void testGetProxy() throws Exception {
        boolean works=false;
        LeasingSoap result = AMSIUtil.getProxy();
        if (result!=null){
            works=true;
        }
        Assert.assertTrue("true", works);
    }

    @Test
    public void testProcessHR() throws Exception {
        String result = AMSIUtil.processHR("626");
        String replaceMeWithExpectedResult="<EDEX><EDEX><propertyid>626</propertyid></EDEX></EDEX>";
        Assert.assertEquals(replaceMeWithExpectedResult, result);
    }

    @Test
    public void testProcessHR2() throws Exception {
        String result = AMSIUtil.processHR("62", "02/22/2015", "02/24/2015", "02/25/2015", "02/26/2015");
        StringBuilder requeststring = new StringBuilder(261);
        requeststring.append("<EDEX><EDEX><propertyid>62</propertyid><statuschangedatefrom>02/22/2015")
                .append("</statuschangedatefrom><statuschangedateto>02/24/2015")
                .append("</statuschangedateto><transactiondatefrom>02/25/2015")
                .append("</transactiondatefrom><transactiondateto>02/26/2015")
                .append("</transactiondateto></EDEX></EDEX>");


        Assert.assertEquals(requeststring.toString(), result);
    }

    @Test
    public void testConvertStringToDocument() throws Exception {
    	boolean val=false;
        Document result = AMSIUtil.convertStringToDocument("<Properties><Property PropertyId=\"002\"honeNo=\"\"  Be2x1S /></Properties>");
        if(result!=null){
        	val=true;        	
        }
        Assert.assertFalse(val);
    }
}
