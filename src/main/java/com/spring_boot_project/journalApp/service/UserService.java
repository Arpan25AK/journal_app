package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.UserRepository;
import com.spring_boot_project.journalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        UserRepository.save(user);
    }

    public void saveNewEntry(User User){
        UserRepository.save(User);
    }

    public List<User> getAll(){
        return UserRepository.findAll();
    }

    public Optional<User> findById(ObjectId Id){
        return UserRepository.findById(Id);
    }

    public void deleteById(ObjectId id){
        UserRepository.deleteById(id);
    }

    public User findByuserName(String Username){
        return UserRepository.findByuserName(Username);
    }
}
