package com.ch.sagashop.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderCreatedMessage {
    // Micrometer Tracing...
    private String requestId;   // 주문과 관련된 로그 추적용 ID
    private Long productId;
    private String productName;

}
