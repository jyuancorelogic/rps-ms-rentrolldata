package com.corelogic.rentrolldata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class RentrolldataApplication {

	public static void main(String[] args) {
		log.info("Application start. Context initialisation...");
			SpringApplication.run(RentrolldataApplication.class, args);
		log.info("Application started. Context initialised.");
	}

}

