package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserService {

    private final MongoTemplate mongoTemplate;

    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class,"user");
    }

    public ResponseEntity userRegister(User newUser) {
        if (mongoTemplate.find(query(where("user_email").is(newUser.getUser_email())), User.class).size()==0) {
            mongoTemplate.save(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity userSignIn(User user) {
        List<User> resUser = mongoTemplate.find(query(where("user_email").is(user.getUser_email())), User.class);
        if (resUser.size() > 0 &&
                user.getUser_email().equals(resUser.get(0).getUser_email()) &&
                user.getUser_password().equals(resUser.get(0).getUser_password())) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
