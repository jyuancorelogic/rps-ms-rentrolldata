package com.corelogic.rps.rentrolldata.services;



import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;







@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()

@ActiveProfiles("itest")
public class AMSIPropertysItest {

    @Autowired
    private AmsiService amsiService;
    
    @Test
    public void getPropertyListAMSItest() {
     String result="";
		result = amsiService.getPropertyListAMSI("fasrclk", "fasrclk", "esite clk");
	
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }
}
