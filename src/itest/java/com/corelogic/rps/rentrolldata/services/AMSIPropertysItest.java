package com.corelogic.rps.rentrolldata.services;

import java.rmi.RemoteException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.corelogic.rps.rentrolldata.RentRollApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@ContextConfiguration(classes = {RentRollApplication.class})
@ActiveProfiles("itest")
public class AMSIPropertysItest {

    @Autowired
    private AMSIPropertys amsiproperty;
    
    @Test
    public void getPropertyListAMSI() throws RemoteException {
     String result="";
		result = amsiproperty.getPropertyListAMSI("far", "far","","http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx");
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }
}
