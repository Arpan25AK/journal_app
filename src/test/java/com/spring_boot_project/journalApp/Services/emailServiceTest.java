package com.spring_boot_project.journalApp.Services;

import com.spring_boot_project.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring_boot_project.journalApp.Enum.Sentiment;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class emailServiceTest {

    @Autowired
    private EmailService emailService;

    @ParameterizedTest
    @EnumSource(Sentiment.class)
    public void emailTest(Sentiment sentiment){
        String subject = "email sentiment" + sentiment;
        emailService.sendEmail("arpanKotian@gmail.com",subject,"user Sentiment",sentiment);

        System.out.println("email Sent");
    }
}
