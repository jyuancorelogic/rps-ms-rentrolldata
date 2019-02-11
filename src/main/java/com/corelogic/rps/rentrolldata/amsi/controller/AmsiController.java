package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 675321 on 2/6/2019.
 */

    @Component
    @Log4j2
    public class AmsiController {

        @Autowired
        AmsiService amsiservice;

        @Scheduled(cron = "${amsi.cronExpression}")
        public void getAmsiRentRollData() {
            amsiservice.executeAMSIServices();


        }
    }
