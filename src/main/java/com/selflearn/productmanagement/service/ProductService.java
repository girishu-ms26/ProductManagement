package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProductsList() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public String saveProduct(Product product) {
        if (productRepository.existsById(product.getId()) == true) {
            return "Product with ID " + product.getId() + " already exists";
        } else {
            productRepository.save(product);
            return "Saved";
        }
    }

    public String saveListOfProducts(List<Product> products) {
        productRepository.saveAll(products);
        return "Saved/Updated all products in the List";
    }

    public String updateProduct(Product product) {
        if (productRepository.existsById(product.getId()) == true) {
            productRepository.save(product);
            return "Updated";
        } else {
            return "Product with ID " + product.getId() + " not found";
        }
    }

    public String deleteProduct(String id){
        if(productRepository.existsById(id)==true){
            productRepository.deleteById(id);
            return "Deleted product with ID "+id;
        }
        else{
            return "Product with " +id+" not found";
        }
    }
}