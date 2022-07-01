package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProductsList(){
        return productService.getAllProductsList();
    }

    @GetMapping("/products/{product_name}")
    public List getProductByProduct_name(@PathVariable String product_name){
        return productService.getProductByProduct_name(product_name);
    }

    @PostMapping("/product")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/products")
    public String saveListOfProducts(@RequestBody List<Product> products){
        return productService.saveListOfProducts(products);
    }

    @DeleteMapping("/products")
    public String deleteAllProducts(){
        return productService.deleteAll();
    }

     @PutMapping("/products")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{product_name}")
    public String deleteProduct(@PathVariable String product_name){
        return productService.deleteProduct(product_name);
    }
}