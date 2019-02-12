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
		return vendorRequestParamsRepository.findByVendor(vendor);
		
	}

	public List<VendorRequestParams> getVendorDataByFurnisher(String furnisher)
	{
		return vendorRequestParamsRepository.findByFurnisher(furnisher);
		
	}
	
}
