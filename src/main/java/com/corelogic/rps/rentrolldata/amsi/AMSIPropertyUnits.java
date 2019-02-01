package com.corelogic.rps.rentrolldata.amsi;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.corelogic.rps.rentrolldata.amsi.generated.LeasingSoap;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class AMSIPropertyUnits {

	public String getPropertyUnits(AMSIInputs inputs) {
		String result = "";
		try {
			URL urladdress = new URL(inputs.getUrl());
			LeasingSoap port = AMSIUtil.getProxy(urladdress);
			String proprequest = AMSIUtil.processHR(inputs.getPropertyId());
			result = port.getPropertyUnits(inputs.getUsername(), inputs.getPassword(), inputs.getPortfolio(),
					proprequest);
			if (log.isInfoEnabled()) {
				log.info("result" + result);
			}
		} catch (MalformedURLException e) {
			if (log.isInfoEnabled()) {
				log.info("MalformedURLException" + e);
			}

		}

		return result;

	}

}
