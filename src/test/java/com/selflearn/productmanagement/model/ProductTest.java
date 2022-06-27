package com.selflearn.productmanagement.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest {

    Product product = new Product();
    Product p1 = new Product("1", "ABCD", 1, 20);

    @Test
    public void productIdTest() {
        product.setId("1");
        assertThat(product.getId()).isEqualTo("1");
        assertThat(p1.getId()).isEqualTo("1");
    }

    @Test
    public void productPriceTest(){
        product.setPrice(123);
        assertThat(product.getPrice()).isEqualTo(123);
        assertThat(p1.getPrice()).isEqualTo(20);
    }

    @Test
    public void productAvailableQtyTest(){
        product.setAvailable_quantity(123);
        assertThat(product.getAvailable_quantity()).isEqualTo(123);
        assertThat(p1.getAvailable_quantity()).isEqualTo(1);
    }

    @Test
    public void product_nameTest(){
        product.setProduct_name("Iphone");
        assertThat(product.getProduct_name()).isEqualTo("Iphone");
        assertThat(p1.getProduct_name()).isEqualTo("ABCD");
    }
}
