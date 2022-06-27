package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductManagementController {

    @GetMapping("/products")
    public List<Product> getAllProductsList(){
        return null;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        return null;
    }

    @PostMapping("/product")
    public String saveProduct(@RequestBody Product product){
        return "Saved Product with name "+product.getProduct_name();
    }

    @PostMapping("/products")
    public String saveListOfProducts(@RequestBody List<Product> products){
        return "Saved "+products.size()+ " Products";
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product product){
        return "Updated product with id "+product.getId();
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable String id){
        return "Deleted product with ID "+id;
    }
}