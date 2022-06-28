package com.selflearn.productmanagement.repository;

import com.selflearn.productmanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
