package com.spring_boot_project.journalApp.repository;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByuserName(String Username);

    void deleteByUserName(String Username);

}
