package com.corelogic.rps.rentrolldata.yardi.service;

import javax.xml.ws.BindingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.YardiUtils;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.yardi.generated.GetPropertyConfigurationsResponse;
import com.corelogic.rps.rentrolldata.yardi.generated.GetUnitConfigurationResponse.GetUnitConfigurationResult;
import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;



@Service
public class YardiService {

	@Autowired
	AuditService auditService;

	public Document getYardiProperties(VendorRequestParams vendorRequestParams)  {		
		Document document = null;
		ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
		BindingProvider bindingProvider = (BindingProvider) yardiService;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vendorRequestParams.getVendorServiceURL());
		GetPropertyConfigurationsResponse.GetPropertyConfigurationsResult propertyConfigurationResult = yardiService
				.getPropertyConfigurations(vendorRequestParams.getLoginId(), vendorRequestParams.getPasword(), vendorRequestParams.getServer(), vendorRequestParams.getVendorDatabase(), vendorRequestParams.getPlatform(), vendorRequestParams.getEntity(),
						vendorRequestParams.getLicence());
		Object propertyResult = propertyConfigurationResult.getContent().get(0);
		Element element = (Element) propertyResult;
		document = element.getOwnerDocument();

		return document;

	}

	public Document getYardiUnitConfiguration(VendorRequestParams vendorRequestParams, String property)
					 {
		Document document = null;

		ItfRentersInsurance30Soap yardiService = YardiUtils.getProxy();
		BindingProvider bindingProvider = (BindingProvider) yardiService;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vendorRequestParams.getVendorServiceURL());
		GetUnitConfigurationResult propertyConfigurationResult = yardiService.getUnitConfiguration(vendorRequestParams.getLoginId(),
				vendorRequestParams.getPasword(), vendorRequestParams.getServer(), vendorRequestParams.getVendorDatabase(), vendorRequestParams.getPlatform(), property, vendorRequestParams.getEntity(), vendorRequestParams.getLicence());
		Object propertyResult = propertyConfigurationResult.getContent().get(0);
		Element element = (Element) propertyResult;
		document = element.getOwnerDocument();

		return document;
	}

}
