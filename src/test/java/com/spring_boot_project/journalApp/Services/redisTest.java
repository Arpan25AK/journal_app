package com.spring_boot_project.journalApp.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class redisTest {

    @Autowired
    private RedisTemplate<String , Object> redisTemplate;

    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("email", "test@email.com");

        Object email = redisTemplate.opsForValue().get("email");

        System.out.println("email from redis : " + email);
    }
}
