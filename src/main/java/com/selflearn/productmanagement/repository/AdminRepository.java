package com.selflearn.productmanagement.repository;

import com.selflearn.productmanagement.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
}
