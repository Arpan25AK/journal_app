package com.spring_boot_project.journalApp.Scheduler;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.repository.UserRepositoryImpl;
import com.spring_boot_project.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Scheduled(cron = "0 * * * * *")
    public void sendScheduledSAEmail(){
        List<User> users = userRepositoryImpl.getUserForSA();

        for(User user : users){
            emailService.sendEmail(
                    user.getEmail(),
                    "Sentiment Analysis Report",
                    "Hi " + user.getUserName() + ", this is your weekly report."
            );
            System.out.println("Email sent to: " + user.getUserName());
        }
    }
}
