package com.ch.sagashop.controller;

import com.ch.sagashop.dto.OrderRequest;
import com.ch.sagashop.message.OrderCreatedMessage;
import com.ch.sagashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> handleOrder(@RequestBody OrderRequest orderRequest) {
        log.debug("상품PK = {}", orderRequest.getProductId());
        log.debug("상품명 = {}", orderRequest.getProductName());

        OrderCreatedMessage msg = new OrderCreatedMessage(
                UUID.randomUUID().toString(), orderRequest.getProductId(), orderRequest.getProductName()
        );

        orderService.sendMessage(msg);

        return ResponseEntity.ok(Map.of("orderResult", "주문 성공"));
    }
}
