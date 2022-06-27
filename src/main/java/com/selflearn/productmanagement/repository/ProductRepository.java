package com.selflearn.productmanagement.repository;

import com.selflearn.productmanagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
