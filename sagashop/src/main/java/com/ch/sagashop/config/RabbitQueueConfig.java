package com.ch.sagashop.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 추후 MSA로 분리시켰을 때 아래의 빈은, Consumer 쪽에 두는 게 좋다.
@Configuration
public class RabbitQueueConfig {

    @Bean
    public Queue orderCreateQueue() {
        // durable = true 시 서버를 껐다 켜도 존재 (영구저장)
        // = rabbitmqadmin declare queue name=order.create.queue durable=true
        return new Queue("order.create.queue", true);
    }
}
