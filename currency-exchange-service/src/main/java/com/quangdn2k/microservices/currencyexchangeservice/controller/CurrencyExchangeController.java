package com.quangdn2k.microservices.currencyexchangeservice.controller;

import com.quangdn2k.microservices.currencyexchangeservice.domain.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange(10001, "USD", "INR", 65.00);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
