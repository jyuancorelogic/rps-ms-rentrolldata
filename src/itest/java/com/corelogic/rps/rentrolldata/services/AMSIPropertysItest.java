package com.corelogic.rps.rentrolldata.services;



import java.net.MalformedURLException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.corelogic.rps.rentrolldata.amsi.AMSIGetPropertyList;





@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()

@ActiveProfiles("itest")
public class AMSIPropertysItest {

    @Autowired
    private AMSIGetPropertyList amsiproperty;
    
    @Test
    public void getPropertyListAMSItest() throws MalformedURLException{
     String result="";
		result = amsiproperty.getPropertyListAMSI(null);
	
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }
}
