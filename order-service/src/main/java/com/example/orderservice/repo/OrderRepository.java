package com.example.orderservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.orderservice.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {}
