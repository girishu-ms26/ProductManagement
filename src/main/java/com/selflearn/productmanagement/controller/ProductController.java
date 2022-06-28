package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProductsList(){
        return productService.getAllProductsList();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/products")
    public String saveListOfProducts(@RequestBody List<Product> products){
        return productService.saveListOfProducts(products);
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}