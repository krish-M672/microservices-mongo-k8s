package com.example.inventory.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class AvailabilityResponse {
    private final String sku;
    private final boolean available;
    private final int requested;
    private final int inStock;
}
