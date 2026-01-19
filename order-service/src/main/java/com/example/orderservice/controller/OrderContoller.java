package com.example.orderservice.controller;


import com.example.orderservice.model.Order;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderContoller {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderContoller(OrderService orderService, OrderRepository orderRepository){
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(String sku, int qty){
        Order order = orderService.createOrder(sku, qty);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

}
