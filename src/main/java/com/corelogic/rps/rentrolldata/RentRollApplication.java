/*
 * Copyright (c) 2017 CoreLogic, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CoreLogic, Inc.
 * It is furnished under license and may only be used or copied in accordance
 * with the terms of such license.
 * This software is subject to change without notice and no information
 * contained in it should be construed as commitment by CoreLogic, Inc.
 * CoreLogic, Inc. cannot accept any responsibility, financial or otherwise, for any
 * consequences arising from the use of this software except as otherwise stated in
 * the terms of the license.
 */

package com.corelogic.rps.rentrolldata;




import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.corelogic.rps.rentrolldata.amsi.AMSIGetPropertyList;



@SpringBootApplication
public class RentRollApplication {
	


    public static void main(String[] args) {
        SpringApplication.run(RentRollApplication.class, args);
        AMSIGetPropertyList aim= new AMSIGetPropertyList();
        try {
			aim.getPropertyListAMSI();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
