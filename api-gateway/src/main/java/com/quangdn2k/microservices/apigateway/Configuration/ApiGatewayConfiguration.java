package com.quangdn2k.microservices.apigateway.Configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouteR(RouteLocatorBuilder builder) {
        //add header here ?
        Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get").uri("http://google.com");
        return builder.routes().route(routeFunction ).build();
    }
}
