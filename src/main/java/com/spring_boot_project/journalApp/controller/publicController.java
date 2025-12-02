package com.spring_boot_project.journalApp.controller;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class publicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthcheck(){
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUsers(@RequestBody User user){
        userService.saveEntry(user);
    }
}
