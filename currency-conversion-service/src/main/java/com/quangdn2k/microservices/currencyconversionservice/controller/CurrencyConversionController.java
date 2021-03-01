package com.quangdn2k.microservices.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        CurrencyConversion currencyConversion = new CurrencyConversion(10001, "USD", "INR", 65, 22, 2222);
        currencyConversion.setEnvironment(environment.getProperty("local.server.port"));

        ResponseEntity<CurrencyConversion> entityResponse = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR", CurrencyConversion.class);
        CurrencyConversion data = entityResponse.getBody();

        currencyConversion.setFrom(data.getFrom());
        currencyConversion.setTo(data.getTo());
        return currencyConversion;
    }
}
