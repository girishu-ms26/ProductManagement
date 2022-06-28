package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.Admin;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final MongoTemplate mongoTemplate;

    public AdminService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseEntity adminRegister(Admin newAdmin) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity adminSignIn(Admin admin) {
        return null;
    }
}
