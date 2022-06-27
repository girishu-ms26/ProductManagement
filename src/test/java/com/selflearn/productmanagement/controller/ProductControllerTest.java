package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.repository.ProductRepository;
import com.selflearn.productmanagement.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProductsTest() {
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);
        when(productService.getAllProductsList()).thenReturn(products);
        assertThat(productController.getAllProductsList().size()).isEqualTo(2);
    }

    @Test
    public void getProductById(){
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);
        when(productService.getProductById("2")).thenReturn(Optional.of(p2));
        assertThat(productController.getProductById("2").get().getId()).isEqualTo("2");
    }

    @Test
    public void saveProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productService.saveProduct(p1))
                .thenReturn("Saved")
                .thenReturn("Product with ID " + p1.getId() + " already exists");
        assertThat(productController.saveProduct(p1)).isEqualTo("Saved");
        assertThat(productController.saveProduct(p1))
                .isEqualTo("Product with ID " + p1.getId() + " already exists");
    }

    @Test
    public void saveListOfProducts(){
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);
        when(productService.saveListOfProducts(products))
                .thenReturn("Saved/Updated all products in the List");
        assertThat(productController.saveListOfProducts(products))
                .isEqualTo("Saved/Updated all products in the List");
    }

    @Test
    public void updateProducts(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productService.updateProduct(p1)).thenReturn(("Updated"));
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productController.updateProduct(p1)).isEqualTo("Updated");
    }

    @Test
    public void updateProducts_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productService.updateProduct(p1))
                .thenReturn(("Product with ID " + p1.getId() + " not found"));
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productController.updateProduct(p1))
                .isEqualTo("Product with ID " + p1.getId() + " not found");
    }

    @Test
    public void deleteProductTest(){
        when(productService.deleteProduct("2")).thenReturn("Deleted");
        assertThat(productController.deleteProduct("2")).isEqualTo("Deleted");
    }
}
