package com.corelogic.rps.rentrolldata.vendordata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corelogic.rps.rentrolldata.vendordata.repository.VendorRequestParamsRepository;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import java.util.List;

@Service
public class VendorRequestService {

	
	@Autowired
	private VendorRequestParamsRepository vendorRequestParamsRepository;
	
	public List<VendorRequestParams> getVendorRequestData(String vendor)
	{
		List<VendorRequestParams> VendorRequestParamsList=vendorRequestParamsRepository.findByVendor(vendor);
		return VendorRequestParamsList;
	}

	public List<VendorRequestParams> getVendorDataByFurnisher(String furnisher)
	{
		List<VendorRequestParams> VendorRequestParamsList=vendorRequestParamsRepository.findByFurnisher(furnisher);
		return VendorRequestParamsList;
	}
	
}
