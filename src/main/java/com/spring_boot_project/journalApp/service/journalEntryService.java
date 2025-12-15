package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.entity.journalEntry;
import com.spring_boot_project.journalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(journalEntry journalEntry, String userName) {
        try {
            User user = userService.findByuserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            journalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("A error has occurred during the save operation", e);
        }
    }

    public void saveEntry(journalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<journalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId Id) {
        return journalEntryRepository.findById(Id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByuserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("A error has occurred during the delete operation", e);
        }
        return removed;
    }
}
