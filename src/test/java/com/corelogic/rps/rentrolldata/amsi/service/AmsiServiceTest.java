package com.corelogic.rps.rentrolldata.amsi.service;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/13/2019.
 */
public class AmsiServiceTest {

    @InjectMocks
    AmsiService amsiService;

    public static final String esiteclk="esite clk";
    public static final String fasrclk="fasrclk";
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPropertyListAMSI() throws Exception {
        String result = amsiService.getPropertyListAMSI( fasrclk, fasrclk, esiteclk);
              Assertions.assertThat(result.length()).isGreaterThan(0);
    }

    @Test
    public void testGetPropertyResidents() throws Exception {
        String result = amsiService.getPropertyResidents( fasrclk, fasrclk, esiteclk, "184");
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }

    @Test
    public void testGetPropertyUnits() throws Exception {
        String result = amsiService.getPropertyUnits( fasrclk, fasrclk, esiteclk, "002");
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }

    @Test
    public void testGetResidentsByStatusChangeOrTransactionDateForResidents() throws Exception {
        String result = amsiService.getResidentsByStatusChangeOrTransactionDateForResidents( fasrclk, fasrclk, esiteclk, "120");
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }

    @Test
    public void testGetResidentsByStatusChangeOrTransactionDateForClients() throws Exception {
        String result = amsiService.getResidentsByStatusChangeOrTransactionDateForClients( fasrclk, fasrclk, esiteclk, "220");
        Assertions.assertThat(result.length()).isGreaterThan(0);
    }
}
