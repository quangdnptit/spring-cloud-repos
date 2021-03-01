package com.quangdn2k.microservices.limitsservice.controller;

import com.quangdn2k.microservices.limitsservice.config.Configuration;
import com.quangdn2k.microservices.limitsservice.domain.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimit() {
        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
