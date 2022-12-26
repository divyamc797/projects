package com.divya.micro1.microserviceA.controller;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductsController {
    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Value("${waitDurationInOpenState}")
    private long waitDurationInOpenState;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        //No configuration
        //below coed should be in service class
        //CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(waitDurationInOpenState))
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .recordExceptions(IOException.class, TimeoutException.class)
                //.ignoreExceptions(BusinessException.class, OtherBusinessException.class)
                .build();

        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        CircuitBreaker circuitBreaker = circuitBreakerRegistry
                .circuitBreaker("name", circuitBreakerConfig);
return null;
//        String url = "http://localhost:8089/products";
//        return circuitBreaker
//                .executeSupplier(() -> {
//                    ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
//                    return ResponseEntity.ok().body(Arrays.stream(response.getBody()).collect(Collectors.toList()));
//                }, throwable -> {
//                    List<Product> products = Arrays.asList(new Product("A", BigDecimal.ONE));
//                    return ResponseEntity.ok().body(products);
//                });

//        ResponseEntity<Product[]> response =
//                restTemplate.getForEntity("http://localhost:8089/products", Product[].class);
//        return ResponseEntity.ok().body(Arrays.stream(response.getBody()).collect(Collectors.toList()));
    }
}
