package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.UserRepository;
import com.spring_boot_project.journalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public void saveEntry(User User){

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
}
