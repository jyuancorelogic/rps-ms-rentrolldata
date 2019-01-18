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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.corelogic.rps.rentrolldata.RentRollApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RentRollApplicationTests {

    @Test
    public void contextLoads() {
       //Context Loads
    }

    @Test
    public void applicationContextTest() {
        RentRollApplication.main(new String[] {});
    }
}
