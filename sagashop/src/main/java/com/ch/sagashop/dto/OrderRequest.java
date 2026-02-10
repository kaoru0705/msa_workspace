package com.ch.sagashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long productId;
    private String productName;

}
