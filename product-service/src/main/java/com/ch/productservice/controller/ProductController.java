package com.ch.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    // 나의 로컬에서 가져온 변수가 아닌, 외부의 Github에서 가져온 변수에 대한 테스트
    @Value("${app.productId}") private Long productId;
    @Value("${app.productName}") private String productName;

    /*
        목록보기
    */
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getProductList() {

        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "productName", productName
        ));
    }
    /*
        상세보기
    */

    @GetMapping("/detail")
    public ResponseEntity<?> getDetail() {

        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "productName", productName
        ));
    }

    // 추후 위의 API 메서드들은 http://~~~~:9991/swagger-ui/index.html


}
