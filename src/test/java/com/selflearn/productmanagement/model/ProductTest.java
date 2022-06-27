package com.selflearn.productmanagement.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest {

    Product product = new Product();
    Product p1 = new Product("1", "ABCD", 1, 20);

    @Test
    public void productIdTest() {
        assertThat(p1.getId()).isEqualTo("1");
    }
}
