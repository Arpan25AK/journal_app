package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.api.response.WhetherResponse;
import com.spring_boot_project.journalApp.appCache.AppCache;
import com.spring_boot_project.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhetherService {
    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WhetherResponse getWhether(String city){
        String Apicall = appCache.appCache.get(AppCache.keys.WEATHER_API.toString())
                .replace(PlaceHolders.CITY, city)
                .replace(PlaceHolders.APIKEY,apikey);
        ResponseEntity<WhetherResponse> response = restTemplate.exchange(Apicall, HttpMethod.GET,null, WhetherResponse.class);
        WhetherResponse body = response.getBody();
        return body;

    }
}
