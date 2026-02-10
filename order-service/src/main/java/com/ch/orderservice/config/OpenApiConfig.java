package com.ch.orderservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "나의 주문 서비스 API", version = "v1.0", description = "주문 서비스 API 문서")
)
public class OpenApiConfig {

}