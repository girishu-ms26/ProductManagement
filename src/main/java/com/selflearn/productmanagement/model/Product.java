package com.selflearn.productmanagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "products")
public class Product {

    @Id
    private String _id;
    private String product_name;
    private int available_quantity;
    private long price;
}
