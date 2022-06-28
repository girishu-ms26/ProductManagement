package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Product;
import com.selflearn.productmanagement.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

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
}
