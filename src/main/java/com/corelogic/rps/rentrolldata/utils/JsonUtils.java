package com.corelogic.rps.rentrolldata.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JsonUtils {

    public HttpEntity<String> getEntityFromJson(String jsonPath) throws URISyntaxException, IOException {
        URL url = getClass().getResource(jsonPath);
        Path resPath = Paths.get(url.toURI());
        String requestJson = new String(Files.readAllBytes(resPath), "UTF8");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(requestJson, headers);
    }

    public String getJsonString(String jsonPath) throws URISyntaxException, IOException {
        URL url = getClass().getResource(jsonPath);
        Path resPath = Paths.get(url.toURI());

        return new String(Files.readAllBytes(resPath), "UTF8");
    }

    public <T> String getJsonString(T t) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(t);
    }
}
