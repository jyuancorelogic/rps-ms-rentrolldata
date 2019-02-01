package com.corelogic.rps.rentrolldata.yardi.utils;

import java.net.URL;

import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30;
import com.corelogic.rps.rentrolldata.yardi.generated.ItfRentersInsurance30Soap;

public class YardiUtils {

	public static ItfRentersInsurance30Soap getProxy() {
		ItfRentersInsurance30 service = new ItfRentersInsurance30();
		return service.getItfRentersInsurance30Soap();
	}

}
