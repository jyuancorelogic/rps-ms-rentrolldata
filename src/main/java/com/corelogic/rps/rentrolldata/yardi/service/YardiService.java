package com.corelogic.rps.rentrolldata.yardi.service;

import javax.xml.ws.BindingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.YardiUtils;
import com.corelogic.rps.rentrolldata.yardi.generated.GetPropertyConfigurationsResponse;
import com.corelogic.rps.rentrolldata.yardi.generated.GetUnitConfigurationResponse.GetUnitConfigurationResult;
import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class YardiService {

	@Autowired
	AuditService auditService;

	public Document getYardiProperties(String username, String password, String serverName, String databaseName,
			String platform, String interfaceEntity, String interfaceLicence, String yardiEndPoint) throws Exception {
		org.w3c.dom.Document document = null;
		try {
			ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
			BindingProvider bindingProvider = (BindingProvider) yardiService;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, yardiEndPoint);
			GetPropertyConfigurationsResponse.GetPropertyConfigurationsResult propertyConfigurationResult = yardiService
					.getPropertyConfigurations(username, password, serverName, databaseName, platform, interfaceEntity,
							interfaceLicence);
			Object propertyResult = (Object) propertyConfigurationResult.getContent().get(0);
			ElementNSImpl element = (ElementNSImpl) propertyResult;
			document = element.getOwnerDocument();
		} catch (Exception e) {
			log.info("error while retrieving yardi proeprties" + e.getMessage());
			throw e;

		}
		return document;

	}

	public Document getYardiUnitConfiguration(String username, String password, String serverName, String databaseName,
			String platform, String interfaceEntity, String interfaceLicence, String yardiEndPoint, String property)
			throws Exception {
		Document document = null;
		try {
			ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
			BindingProvider bindingProvider = (BindingProvider) yardiService;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, yardiEndPoint);
			GetUnitConfigurationResult propertyConfigurationResult = yardiService.getUnitConfiguration(username,
					password, serverName, databaseName, platform, property, interfaceEntity, interfaceLicence);
			Object propertyResult = propertyConfigurationResult.getContent().get(0);
			ElementNSImpl element = (ElementNSImpl) propertyResult;
			document = element.getOwnerDocument();

		} catch (Exception e) {
			log.info("error while retrieving yardi proeprties" + e.getMessage());
			throw e;

		}
		return document;
	}

}
