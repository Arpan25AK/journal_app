package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.api.response.WhetherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhetherService {
    @Value("${wheather.api.key}")
    private String apikey;

    private static final String Api = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WhetherResponse getWhether(String city){
        String Apicall = Api.replace("CITY" , city).replace("API_KEY",apikey);
        ResponseEntity<WhetherResponse> response = restTemplate.exchange(Apicall, HttpMethod.GET,null, WhetherResponse.class);
        WhetherResponse body = response.getBody();
        return body;

    }
}
