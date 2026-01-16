package com.spring_boot_project.journalApp.controller;

import com.spring_boot_project.journalApp.api.response.WhetherResponse;
import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.repository.UserRepository;
import com.spring_boot_project.journalApp.service.UserService;
import com.spring_boot_project.journalApp.service.WhetherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WhetherService whetherService;

    @PostMapping
    public void createUsers(@RequestBody User user){
        userService.saveNewUser(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByuserName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WhetherResponse whetherResponse = whetherService.getWhether("Dubai");
        String greeting = "";
        if(whetherResponse != null){
            greeting = " wheather in " + whetherResponse.getLocation().getName()
                    + " is " + whetherResponse.getCurrent().getTemperature()
                    + " and the city is facing "
                    + whetherResponse.getCurrent().getWeatherDescriptions();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }
}
