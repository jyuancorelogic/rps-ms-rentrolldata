package com.corelogic.rps.rentrolldata.amsi.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;

//import lombok.extern.log4j.Log4j2;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/7/2019.
 */
//@Log4j2
public class AmsiServiceTest {
    
    @InjectMocks
    AmsiService amsiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteAMSIServices() throws Exception {
        boolean result = amsiService.executeAMSIServices();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetPropertyListAMSI() throws Exception {
    	boolean value=false;
        String result = amsiService.getPropertyListAMSI();
        if(result !=null){
        	value=true;
        }
        Assert.assertEquals(true, value);
    }

    @Test
    public void testGetPropertyResidents() throws Exception {
        amsiService.getPropertyResidents("120");
    }

    @Test
    public void testGetPropertyUnits() throws Exception {
        amsiService.getPropertyUnits("121");
    }

    @Test
    public void testGetResidentsByStatusChangeOrTransactionDateForResidents() throws Exception {
        amsiService.getResidentsByStatusChangeOrTransactionDateForResidents("626");
    }

    @Test
    public void testGetResidentsByStatusChangeOrTransactionDateForClients() throws Exception {
        amsiService.getResidentsByStatusChangeOrTransactionDateForClients("621");
    }
    
  /*  @Test
    public void log(){
    	boolean res=false;
    	if(log.isInfoEnabled()){
    		res=true;
    	}
    	Assert.assertEquals(true,res);
}*/
}
