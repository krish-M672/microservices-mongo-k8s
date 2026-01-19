package com.example.inventory.contoller;


import com.example.inventory.api.AvailabilityResponse;
import com.example.inventory.api.UpsertProductRequest;
import com.example.inventory.model.Product;
import com.example.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLType;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;


    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> upsert(@Valid @RequestBody UpsertProductRequest request){
        Product product = inventoryService.upsert(request.getSku(), request.getQuantity());
        return ResponseEntity.ok(product);
    }

    @GetMapping("/check")
    public ResponseEntity<AvailabilityResponse> check(@RequestParam String sku , @RequestParam Integer quantity){
        boolean available = inventoryService.hasStock(sku, quantity);
        int inStock = inventoryService.getStock(sku);
        return ResponseEntity.ok(new AvailabilityResponse(sku,available,quantity,inStock));
    }
}
