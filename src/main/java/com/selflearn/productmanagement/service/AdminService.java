package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.Admin;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class AdminService {

    private final MongoTemplate mongoTemplate;

    public AdminService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Admin> getAllAdmins() {
        return mongoTemplate.findAll(Admin.class,"admin");
    }

    public ResponseEntity adminRegister(Admin newAdmin) {
        if (mongoTemplate.find(query(where("admin_email").is(newAdmin.getAdmin_email())), Admin.class).size()==0) {
            mongoTemplate.save(newAdmin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity adminSignIn(Admin admin) {
        List<Admin> resAdmin = mongoTemplate.find(query(where("admin_email").is(admin.getAdmin_email())), Admin.class);
        if (resAdmin.size() > 0 &&
                admin.getAdmin_email().equals(resAdmin.get(0).getAdmin_email()) &&
                    admin.getAdmin_password().equals(resAdmin.get(0).getAdmin_password())) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}