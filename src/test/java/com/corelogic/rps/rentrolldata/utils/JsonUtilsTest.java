package com.corelogic.rps.rentrolldata.utils;



import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.corelogic.rps.rentrolldata.audit.data.RentrollRequest;


/**
 * Created by 675321 on 2/18/2019.
 */
public class JsonUtilsTest {
	
    JsonUtils jsonUtils = new JsonUtils();


    @Test
    public void testGetJsonString() throws Exception {
        Assertions.assertThat(jsonUtils.getJsonString(RentrollRequest.builder().vendor("AMSI").build())).contains("AMSI");
    }


}

