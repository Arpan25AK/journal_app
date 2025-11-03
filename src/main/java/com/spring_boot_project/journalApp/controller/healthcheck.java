package com.spring_boot_project.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheck {

    @GetMapping("/health-check")
    public String healthcheck(){
        return "OK";
    }
}
