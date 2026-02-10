package com.ch.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${app.orderId}") private Long orderId;
    @Value("${app.orderName}") private String orderName;

    @GetMapping("/main")
    public ResponseEntity<?> getOrderList() {

        return ResponseEntity.ok(Map.of(
                "orderId", orderId,
                "orderName", orderName
        ));
    }
}
