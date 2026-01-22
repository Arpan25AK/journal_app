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

     public List<User> getUserForSA(){
         Query query = new Query();
         // Regex for valid email format
         query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
         // User must have turned ON sentiment analysis
         query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

         return mongoTemplate.find(query, User.class);
    }
}
