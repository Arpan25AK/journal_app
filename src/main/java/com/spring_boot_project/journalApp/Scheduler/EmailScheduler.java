package com.spring_boot_project.journalApp.Scheduler;

import com.spring_boot_project.journalApp.Enum.Sentiment;
import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.UserRepositoryImpl;
import com.spring_boot_project.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            Map<Sentiment,Integer> sentimentCount = new HashMap<>();
            List<journalEntry> journalEntries = user.getJournalEntries();

            List<journalEntry> filteredEntries = journalEntries.stream()
                    .filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .collect(Collectors.toList());

            for(journalEntry entry : filteredEntries){
                if(entry.getSentiment() != null){
                    sentimentCount.put(entry.getSentiment(),sentimentCount.getOrDefault(entry.getSentiment(), 0) + 1);
                }
            }
            Sentiment mostFreqSentiment = null;
            int maxCount = 0;

            for(Map.Entry<Sentiment,Integer> entry : sentimentCount.entrySet()){
                if(entry.getValue() > maxCount){
                    maxCount = entry.getValue();
                    mostFreqSentiment = entry.getKey();
                }
            }

            if (mostFreqSentiment != null) {
                emailService.sendEmail(
                        user.getEmail(),
                        "Sentiment Analysis",
                        user.getUserName(),
                        mostFreqSentiment
                );
            }
        }
    }
}
