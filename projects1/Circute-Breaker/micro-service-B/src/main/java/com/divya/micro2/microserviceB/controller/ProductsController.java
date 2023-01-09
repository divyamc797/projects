package com.divya.micro2.microserviceB.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = Arrays.asList(
                new Product("product1", BigDecimal.valueOf(10)),
                new Product("product2", BigDecimal.valueOf(20)),
                new Product("product3", BigDecimal.valueOf(30)),
                new Product("product4", BigDecimal.valueOf(40)),
                new Product("product5", BigDecimal.valueOf(50)));
        return ResponseEntity.ok().body(products);
    }
}
