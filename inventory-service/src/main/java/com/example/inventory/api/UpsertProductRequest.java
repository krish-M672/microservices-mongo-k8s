package com.example.inventory.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpsertProductRequest {

    @NotBlank
    private String sku;

    @Min(0)
    private int quantity;


}
