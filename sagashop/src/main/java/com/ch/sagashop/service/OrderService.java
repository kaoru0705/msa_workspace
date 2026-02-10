package com.ch.sagashop.service;

import com.ch.sagashop.message.OrderCreatedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    // RabbitMQ 서버로 메시지가 등록됨!!
    // 서비스는 엔티티를 사용하는 게 원칙상 맞지만 간단하게 함
    public void sendMessage(OrderCreatedMessage msg) {

        // 주문마다 메시지 객체를 새로 만들기

        // rabbitmqadmin publish exchange=amq.default routing_key=order.create.queue payload="hello"
        // 첫 번째 인자 ""가 default라는 뜻
        rabbitTemplate.convertAndSend("", "order.create.queue", msg);
        log.debug("RabbitMQ로 주문 메시지 전송함");
    }
}