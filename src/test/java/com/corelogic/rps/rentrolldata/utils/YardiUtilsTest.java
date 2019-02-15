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
        ItfRentersInsurance30Soap result = YardiUtils.getProxy();
        Assert.assertNotNull(result);    
       
    }

    @Test
    public void testConvertDocumentToString() throws Exception {
    	String result = YardiUtils.convertDocumentToString(null);
    	Assert.assertNotNull(result);  

    }
}

