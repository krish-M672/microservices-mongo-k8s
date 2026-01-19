package com.example.orderservice.service;

import com.example.orderservice.client.InventoryClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repo.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient){
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }


    public Order createOrder(String sku , int qty){

        boolean isAvailable = inventoryClient.check(sku, qty)
                .map(r ->r.isAvailable())
                .onErrorReturn(false)
                .block();

        Order order = new Order(sku, qty, isAvailable? "CREATED" : "REJECTED");
        return orderRepository.save(order);

    }
}
