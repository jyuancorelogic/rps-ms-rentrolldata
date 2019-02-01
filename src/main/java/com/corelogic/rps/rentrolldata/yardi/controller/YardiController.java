package com.corelogic.rps.rentrolldata.yardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corelogic.rps.rentrolldata.yardi.service.YardiProperties;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class YardiController {

	@Autowired
	YardiProperties yardiProperties;

	@GetMapping(value = "rentroll/yardi")
	public void getYardiRentRollData() {
		yardiProperties.getYardiProperties();
		yardiProperties.getYardiUnitConfiguration();

	}
}
