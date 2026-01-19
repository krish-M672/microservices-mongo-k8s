package com.example.orderservice.controller;


import com.example.orderservice.api.CreateOrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderContoller {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderContoller(OrderService orderService, OrderRepository orderRepository){
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody CreateOrderRequest req) {
        return ResponseEntity.ok(orderService.createOrder(req.getSku(), req.getQuantity()));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

}
