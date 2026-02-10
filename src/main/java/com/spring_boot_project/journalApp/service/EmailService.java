package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.Enum.Sentiment;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @CircuitBreaker(name = "emailBreaker", fallbackMethod = "emailFallBack")
    public void sendEmail(String to, String subject, String name, Sentiment sentiment) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("City", "Dubai");
        context.setVariable("sentiment", sentiment);

        String htmlContent = templateEngine.process("email-template", context);

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    // Fallback method must have the EXACT SAME signature + Throwable
    public void emailFallBack(String to, String subject, String name, Sentiment sentiment, Throwable t) {
        log.error("❌ Fallback triggered! Email failed for user: {}. Error: {}", name, t.getMessage());
    }
}