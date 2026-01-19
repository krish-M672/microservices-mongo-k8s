package com.example.orderservice.api;

public class InventoryCheckResponse {
    private String sku;
    private boolean available;
    private int requested;
    private int inStock;

    public String getSku() { return sku; }
    public boolean isAvailable() { return available; }
    public int getRequested() { return requested; }
    public int getInStock() { return inStock; }
}
