package com.ch.sagashop.consumer;

import com.ch.sagashop.message.OrderCreatedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryConsumer {

    // RabbitMQ의 구독한 Queue로부터 메시지 가져오기
    // RabbitListener 토끼 서버 청취할 거야 내가 구독하는 queue는 바로 이거야
    // 프론트단에서 주문한 게 OrderController로 가고 그걸 RabbitMQ가 받고 이걸 리스너에 등록하면 알아서 RabbitMQ가 보내준다.
    // 여기서 msg로 받을 수 있는 이유는? 네트워크는 전송은 JSON 아닌가?
    // RabbitConfig가 json으로 바꿔주기 때문에 OrderCreatedMessage msg로 받을 수 있다.
    // Listener를 주석처리하면? 소비자가 없으므로 메시지가 쌓일 것이다.
    @RabbitListener(queues = "order.create.queue")
    public void receiveMessage(OrderCreatedMessage msg) {
        log.debug("RabbitMQ로 수신한 메시지는 {}", msg);

        // 재고관리 팀의 개발자는 여기서 재고 처리를 해야 함...
        log.debug("재고관리팀으로 주문정보 수신받음, 지금부터 재고 처리 할 거임..");
    }
}
