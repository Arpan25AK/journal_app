package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.journalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public saveEntry(journalEntry){
        journalEntryRepository.save(journalEntry);
    }
}
