package com.spring_boot_project.journalApp.controller;

import com.spring_boot_project.journalApp.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class journalEntryController {

    private Map<Long,journalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<journalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("/id/{myid}")
    public journalEntry getjournaEntryById(@PathVariable Long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public journalEntry deltejournalEntryById(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("/id/{id}")
    public journalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody journalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }
}
