package com.corelogic.rps.rentrolldata.utils;

import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 675321 on 2/11/2019.
 */
public class YardiUtilsTest {

    @Test
    public void testGetProxy() throws Exception {
    	boolean val=false;
        ItfRentersInsurance30Soap result = YardiUtils.getProxy();
        if(result!=null){
        	val=true;        	
        }
        Assert.assertEquals(true, val);
       
       // Assert.assertEquals(null, result);
    }

    @Test
    public void testConvertDocumentToString() throws Exception {
    	boolean val=false;
        String result = YardiUtils.convertDocumentToString(null);
        if(result!=null){
        	val=true;        	
        }
        Assert.assertEquals(true, val);
       
        //Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

