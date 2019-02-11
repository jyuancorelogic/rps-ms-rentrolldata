package com.corelogic.rps.rentrolldata.yardi.service;

import com.corelogic.rps.rentrolldata.audit.service.AuditService;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.w3c.dom.Document;

import static org.mockito.Mockito.*;

/**
 * Created by 675321 on 2/11/2019.
 */
public class YardiServiceTest {
    @Mock
    AuditService auditService;
    @Mock
    Logger log;
    @InjectMocks
    YardiService yardiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

/*    @Test
    public void testGetYardiProperties() throws Exception {
        Document result = yardiService.getYardiProperties("username", "password", "serverName", "databaseName", "platform", "interfaceEntity", "interfaceLicence", "yardiEndPoint");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetYardiUnitConfiguration() throws Exception {
        Document result = yardiService.getYardiUnitConfiguration("username", "password", "serverName", "databaseName", "platform", "interfaceEntity", "interfaceLicence", "yardiEndPoint", "property");
        Assert.assertEquals(null, result);
    }*/
}

