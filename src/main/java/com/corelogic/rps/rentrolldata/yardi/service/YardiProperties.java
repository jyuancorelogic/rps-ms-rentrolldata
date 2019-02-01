package com.corelogic.rps.rentrolldata.yardi.service;

import java.util.List;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.corelogic.rps.rentrolldata.yardi.generated.GetPropertyConfigurationsResponse.GetPropertyConfigurationsResult;
import com.corelogic.rps.rentrolldata.yardi.generated.GetUnitConfigurationResponse.GetUnitConfigurationResult;
import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;
import com.corelogic.rps.rentrolldata.yardi.utils.YardiUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class YardiProperties {

	@Value("${yardi.endpoint}")
	private String yardiEndPoint;

	@Value("${yardi.username}")
	private String username;

	@Value("${yardi.password}")
	private String password;

	@Value("${yardi.serverName}")
	private String serverName;

	@Value("${yardi.databaseName}")
	private String databaseName;

	@Value("${yardi.platform}")
	private String platform;

	@Value("${yardi.interfaceEntity}")
	private String interfaceEntity;

	@Value("${yardi.interfaceLicence}")
	private String interfaceLicence;

	public void getYardiProperties() {
		try {
			ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
			BindingProvider bindingProvider = (BindingProvider) yardiService;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,yardiEndPoint);
			GetPropertyConfigurationsResult propertyConfigurationResult = yardiService.getPropertyConfigurations(
					username, password, serverName, databaseName, platform, interfaceEntity, interfaceLicence);
			List<Object> propertyResult = propertyConfigurationResult.getContent();
		} catch (Exception e) {
			log.info("error while retrieving yardi proeprties" + e.getMessage());

		}

	}
	
	public void getYardiUnitConfiguration() {
		try {
			ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
			BindingProvider bindingProvider = (BindingProvider) yardiService;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,yardiEndPoint);
			GetUnitConfigurationResult propertyConfigurationResult = yardiService.getUnitConfiguration(username, password, serverName, databaseName, platform, "bpa", interfaceEntity, interfaceLicence);
			List<Object> propertyResult = propertyConfigurationResult.getContent();
		} catch (Exception e) {
			log.info("error while retrieving yardi proeprties" + e.getMessage());

		}

	}

}
