package com.corelogic.rps.rentrolldata.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by 675321 on 2/11/2019.
 */
public class JsonUtilsTest {
    JsonUtils jsonUtils = new JsonUtils();

 /*   @Test
    public void testGetEntityFromJson() throws Exception {
    	boolean val=false;
        HttpEntity<String> result = jsonUtils.getEntityFromJson("\test\json");
        if(result==null){
        	val=true;        	
        }
        Assert.assertEquals(true, val);
        
    }

    @Test
    public void testGetJsonString() throws Exception {
    	boolean val=false;
        String result = jsonUtils.getJsonString("jsonPath");
        if(result==null){
        	val=true;        	
        }
        Assert.assertEquals(true, val);
       
       
    }

    /*@Test
    public void testGetJsonString2() throws Exception {
        String result = jsonUtils.getJsonString(new T());
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }*/
}