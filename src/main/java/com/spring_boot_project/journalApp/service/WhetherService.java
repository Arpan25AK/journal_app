package com.spring_boot_project.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WhetherService {
    private static final String apikey = "a8aa2c3ccd73f69751edc0de76ba352c";

    private static final String Api = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public String getWhether(String city){
        String finalApi = Api.replace("City" , city).replace("API_KEY",apikey);

    }
}
