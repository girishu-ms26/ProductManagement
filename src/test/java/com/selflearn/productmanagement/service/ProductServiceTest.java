package com.selflearn.productmanagement.service;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProductsListTest(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);

        when(productRepository.findAll()).thenReturn(products);
        assertThat(productService.getAllProductsList().size()).isEqualTo(2);
    }
    
    @Test
    public void getProductByIdTest(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);

        when(productRepository.findById("1")).thenReturn(Optional.of(products.get(0)));
        assertThat(productService.getProductById("1")).isEqualTo(Optional.of(products.get(0)));
    }

    @Test
    public void saveProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productService.saveProduct(p1)).isEqualTo("Product with ID "+ p1.getId() +" already exists");
    }

    @Test
    public void saveProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.saveProduct(p1)).isEqualTo("Saved");
    }

    @Test
    public void saveListOfProductsTest(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("1","Iphone",1,20);
        Product p2 = new Product("2","Nokia",2,30);
        products.add(p1);
        products.add(p2);
        assertThat(productService.saveListOfProducts(products)).isEqualTo("Saved/Updated all products in the List");
    }

    @Test
    public void updateProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productService.updateProduct(p1)).isEqualTo("Updated");
    }

    @Test
    public void updateProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.updateProduct(p1)).isEqualTo("Product with ID " + p1.getId() + " not found");
    }

    @Test
    public void deleteProductTest(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(true);
        assertThat(productService.deleteProduct(p1.getId())).isEqualTo("Deleted product with ID "+p1.getId());
    }

    @Test
    public void deleteProductTest_1(){
        Product p1 = new Product("1","Iphone",1,20);
        when(productRepository.existsById(p1.getId())).thenReturn(false);
        assertThat(productService.deleteProduct(p1.getId())).isEqualTo("Product with " +p1.getId()+" not found");
    }
}
