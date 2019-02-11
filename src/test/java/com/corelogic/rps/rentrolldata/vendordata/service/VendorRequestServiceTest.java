package com.corelogic.rps.rentrolldata.vendordata.service;

import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.vendordata.id.VendorParamsId;
import com.corelogic.rps.rentrolldata.vendordata.repository.VendorRequestParamsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/11/2019.
 */
public class VendorRequestServiceTest {
    @Mock
    VendorRequestParamsRepository vendorRequestParamsRepository;
    @InjectMocks
    VendorRequestService vendorRequestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVendorRequestData() throws Exception {
        when(vendorRequestParamsRepository.findByVendor(anyString())).thenReturn(Arrays.<VendorRequestParams>asList(new VendorRequestParams(new VendorParamsId("vendor", "furnisher"), "vendorServiceType", "vendorServiceURL", "loginId", "pasword", "vendorDatabase", "server", "entity", "platform", "licence", "unitStatus", "dBLive", "lastUpdateUser", LocalDateTime.of(2019, Month.FEBRUARY, 11, 22, 5, 32))));

        List<VendorRequestParams> result = vendorRequestService.getVendorRequestData("vendor");
        Assert.assertEquals(Arrays.<VendorRequestParams>asList(new VendorRequestParams(new VendorParamsId("vendor", "furnisher"), "vendorServiceType", "vendorServiceURL", "loginId", "pasword", "vendorDatabase", "server", "entity", "platform", "licence", "unitStatus", "dBLive", "lastUpdateUser", LocalDateTime.of(2019, Month.FEBRUARY, 11, 22, 5, 32))), result);
    }

    @Test
    public void testGetVendorDataByFurnisher() throws Exception {
        when(vendorRequestParamsRepository.findByFurnisher(anyString())).thenReturn(Arrays.<VendorRequestParams>asList(new VendorRequestParams(new VendorParamsId("vendor", "furnisher"), "vendorServiceType", "vendorServiceURL", "loginId", "pasword", "vendorDatabase", "server", "entity", "platform", "licence", "unitStatus", "dBLive", "lastUpdateUser", LocalDateTime.of(2019, Month.FEBRUARY, 11, 22, 5, 32))));

        List<VendorRequestParams> result = vendorRequestService.getVendorDataByFurnisher("furnisher");
        Assert.assertEquals(Arrays.<VendorRequestParams>asList(new VendorRequestParams(new VendorParamsId("vendor", "furnisher"), "vendorServiceType", "vendorServiceURL", "loginId", "pasword", "vendorDatabase", "server", "entity", "platform", "licence", "unitStatus", "dBLive", "lastUpdateUser", LocalDateTime.of(2019, Month.FEBRUARY, 11, 22, 5, 32))), result);
    }
}

