package com.corelogic.rps.rentrolldata.yardi.service;

import com.corelogic.rps.rentrolldata.audit.service.AuditService;

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
    public static final String yovhyeqo_live="yovhyeqo_live";
    @InjectMocks
    YardiService yardiService;
    public static final String license="MIIBEAYJKwYBBAGCN1gDoIIBATCB/gYKKwYBBAGCN1gDAaCB7zCB7AIDAgABAgJoAQICAIAEAAQQ23OWB9Mvr3tLAnvLm5e9hASByGMz/H5b6mLwEnw9ZXisQk7KrPKdOVt37cGegkYjY9ArPEtkroeFlrRew3Tp+CWFtiyA2tDNx4osvpI2uWaOuKsatS5fGiuoImOhE57hiKFsh8MATTGfFOlXIE0KYbcryGQebHH1c12JyFyCww13Ya4a2nMtJrriyDik/v5yBjSBKlt/jLfPQNJvdFKTpYQJz3ijG4oYtUlhV/nXBfiB05WrNoyZHTZns+59hWWDR9iDkcFJlcvgh2RFwdJTvdt3ZLiqrZKpEQgE";


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

   @Test
    public void testGetYardiProperties() throws Exception {

        Document result = yardiService.getYardiProperties("CLSRRent", "CoreLogic123", "yovhyeqo_live", yovhyeqo_live, "SQL Server", "CoreLogic Renters Insurance", license, "https://www.yardiasp14.com/42258polinger/Webservices/ItfRentersinsurance.asmx");
        Assert.assertNotNull(result);    
    }

    @Test
    public void testGetYardiUnitConfiguration() throws Exception {
    	
        Document result = yardiService.getYardiUnitConfiguration("CLSRRent", "CoreLogic123", yovhyeqo_live, yovhyeqo_live, "SQL Server", "CoreLogic Renters Insurance",license, "https://www.yardiasp14.com/42258polinger/Webservices/ItfRentersinsurance.asmx","123");
        Assert.assertNotNull(result);    
    }
}

