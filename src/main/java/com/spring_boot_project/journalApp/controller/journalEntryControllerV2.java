package com.spring_boot_project.journalApp.controller;

import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.service.journalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

    @Autowired
    private journalEntryService journalEntryService;

    @GetMapping
    public List<journalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }
    @GetMapping("/id/{myid}")
    public journalEntry getjournaEntryById(@PathVariable Long myid){
        return null;
    }

    @DeleteMapping("/id/{myid}")
    public journalEntry deltejournalEntryById(@PathVariable Long myid){
        return null;
    }

    @PutMapping("/id/{id}")
    public journalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody journalEntry myEntry){
        return null;
    }
}
