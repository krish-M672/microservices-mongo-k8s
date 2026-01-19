package com.example.orderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
public class Order {
    @Id
    private String id;

    private String sku;
    private int quantity;
    private String status; // CREATED or REJECTED

    public Order() {}

    public Order(String sku, int quantity, String status) {
        this.sku = sku;
        this.quantity = quantity;
        this.status = status;
    }

    public String getId() { return id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
