package com.quangdn2k.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample")
    @CircuitBreaker(name="default", fallbackMethod = "hardCodeRes")
    public String getSample() {
        logger.info("sample api calling");

        ResponseEntity<String> a = new RestTemplate().getForEntity("http://localhost:111", String.class);
        return a.getBody();
    }

    public String hardCodeRes(Exception ex) {
        return "doan xem";
    }
}
