package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public void saveEntry(journalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<journalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId Id){
        return journalEntryRepository.findById(Id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
