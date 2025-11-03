package com.spring_boot_project.journalApp.controller;

import com.spring_boot_project.journalApp.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {



    @GetMapping
    public List<journalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry){

        return null;
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
