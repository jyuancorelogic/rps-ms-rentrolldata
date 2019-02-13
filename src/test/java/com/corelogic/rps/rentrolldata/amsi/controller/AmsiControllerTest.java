package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import com.corelogic.rps.rentrolldata.audit.data.RequestStatus;
import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import com.corelogic.rps.rentrolldata.utils.JsonUtils;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;
import com.corelogic.rps.rentrolldata.vendordata.service.VendorRequestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/13/2019.
 */
public class AmsiControllerTest {
    @Mock
    AmsiService amsiservice;
    @Mock
    AuditService auditService;
    @Mock
    JsonUtils jsonUtils;
    @Mock
    VendorRequestService vendorRequestService;

    @InjectMocks
    AmsiController amsiController;
    
    public static final String esiteclk="esite clk";
    public static final String fasrclk="fasrclk";
    public static final String url="http://www.clk-pm.net/AMSIweb/edexweb/esite/leasing.asmx";
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAmsiRentRollData() throws Exception {
        when(amsiservice.getPropertyListAMSI(url, fasrclk, fasrclk, esiteclk)).thenReturn("getPropertyListAMSIResponse");
        when(amsiservice.getPropertyResidents(url, fasrclk, fasrclk, esiteclk, "184")).thenReturn("getPropertyResidentsResponse");
        when(amsiservice.getPropertyUnits(url, fasrclk, fasrclk, esiteclk, "184")).thenReturn("getPropertyUnitsResponse");
        when(amsiservice.getResidentsByStatusChangeOrTransactionDateForResidents(url, fasrclk, fasrclk, esiteclk, "184")).thenReturn("getResidentsByStatusChangeOrTransactionDateForResidentsResponse");
        when(auditService.saveRequest("AMSI", esiteclk, RequestStatus.IN_PROGRESS)).thenReturn(0L);
        when(auditService.saveRequestMessage(45613,"getPropertyListAMSI","RENTROLL", "AMSI", "/AMSI/esite clk", RequestStatus.SUCCESS)).thenReturn(0L);
        when(jsonUtils.getJsonString(any())).thenReturn("getJsonStringResponse");
        when(vendorRequestService.getVendorRequestData(anyString())).thenReturn(Arrays.<VendorRequestParams>asList(new VendorRequestParams(null, "WEBSERVICE", url, fasrclk, fasrclk, "SQlSERVER", "server", esiteclk, "platform", "licence", "unitStatus", "dBLive", "lastUpdateUser", LocalDateTime.of(2019, Month.FEBRUARY, 13, 11, 43, 7))));

        amsiController.getAmsiRentRollData();
    }
}

