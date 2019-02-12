package com.corelogic.rps.rentrolldata.amsi.controller;

import com.corelogic.rps.rentrolldata.amsi.service.AmsiService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/7/2019.
 */
public class AmsiControllerTest {
    @Mock
    AmsiService amsiservice;

    @InjectMocks
    AmsiController amsiController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetYardiRentRollData() throws Exception {
        amsiController.getAmsiRentRollData();
    }
}

