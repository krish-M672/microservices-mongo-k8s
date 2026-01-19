package com.example.inventory.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Product {

    @Id
    private String id;

    private String sku;
    private int quantity;


    public Product(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }
}
