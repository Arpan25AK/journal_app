package com.spring_boot_project.journalApp.repository;

import com.spring_boot_project.journalApp.entity.journalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<journalEntry,String> {
}
