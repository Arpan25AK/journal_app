package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.api.response.WhetherResponse;
import com.spring_boot_project.journalApp.appCache.AppCache;
import com.spring_boot_project.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private AppCache appCache;

    public WhetherResponse getWhether(String city){
        String rediskey = "whether : " + city;

        WhetherResponse cachedWhether = (WhetherResponse)redisTemplate.opsForValue().get(rediskey);

        if(cachedWhether != null){
            return cachedWhether;
        }

        String whetherApiUrl = appCache.appCache.get(AppCache.keys.WEATHER_API.toString());

        if(whetherApiUrl == null){
            throw new RuntimeException("whether api not found in db");
        }

        String Apicall = appCache.appCache.get(AppCache.keys.WEATHER_API.toString())
                .replace(PlaceHolders.CITY, city)
                .replace(PlaceHolders.APIKEY,apikey);
        ResponseEntity<WhetherResponse> response = restTemplate.exchange(Apicall, HttpMethod.GET,null, WhetherResponse.class);
        WhetherResponse body = response.getBody();

        if(body != null){
            redisTemplate.opsForValue().set(rediskey, body);
        }
        return body;

    }
}
