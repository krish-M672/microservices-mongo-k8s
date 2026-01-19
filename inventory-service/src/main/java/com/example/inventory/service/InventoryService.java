package com.example.inventory.service;

import com.example.inventory.model.Product;
import com.example.inventory.repo.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private ProductRepository productRepository;

    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product upsert(String sku, int quantity){
        Product product = productRepository.findBySku(sku).orElse(new Product(sku, quantity));
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    public boolean hasStock(String sku, int quantity){
        return productRepository.findBySku(sku).map(product -> product.getQuantity() >= quantity).orElse(false);
    }

    public int getStock(String sku){
        return productRepository.findBySku(sku).map(Product::getQuantity).orElse(0);
    }

}
