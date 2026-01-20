package com.spring_boot_project.journalApp.repository;

import com.spring_boot_project.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    List<User> getUserForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("satish"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
