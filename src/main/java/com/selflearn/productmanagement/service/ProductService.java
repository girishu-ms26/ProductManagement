package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class ProductService {

    private final MongoTemplate mongoTemplate;

    public ProductService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Product> getAllProductsList() {
        return mongoTemplate.findAll(Product.class, "products");
    }

    public List getProductByProduct_name(String product_name) {
        List<Product> return_0 = mongoTemplate.find(query(where("product_name").is(product_name)),Product.class);
        if(return_0.size() > 0){
            return return_0;
        }
        else{
            List<String> return_1 = Collections.singletonList(product_name+" Not Found");
            return return_1;
        }
    }

    public String saveProduct(Product product) {
        if(mongoTemplate.find(query(where("product_name").is(product.getProduct_name())), Product.class).size()==0){
            mongoTemplate.save(product);
            return "Saved";
        }
        else{
            return "Product with name "+product.getProduct_name()+" Already exists";
        }

    }

    public String saveListOfProducts(List<Product> products) {
        for(int i=0;i<products.size();i++){
            if(mongoTemplate.find(query(where("product_name").is(products.get(i).getProduct_name())),Product.class).size()==0) {
                mongoTemplate.save(products.get(i));
            }
        }
        return "Saved/Updated all products in the List";
    }

     public String updateProduct(Product product) {
        if (mongoTemplate.find(query(where("product_name").is(product.getProduct_name())),Product.class).size()>0) {
            mongoTemplate.save(product);
            return "Updated";
        } else {
            return "Product with ID " + product.getProduct_name() + " not found";
        }
    }

    public String deleteAll() {
        mongoTemplate.dropCollection("products");
        return "Dropped Collection";
    }

    public String deleteProduct(String product_name){
        List<Product> res = mongoTemplate.find(query(where("product_name").is(product_name)),Product.class);
        if(res.size()>0){
            mongoTemplate.remove(mongoTemplate.findById(res.get(0).get_id(),Product.class,"products"));
            return "Deleted "+product_name;
        }
        else {
            return "Product with name "+product_name+" not found";
        }
    }
}