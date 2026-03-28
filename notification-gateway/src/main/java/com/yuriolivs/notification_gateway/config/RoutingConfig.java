package com.yuriolivs.notification_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("scheduler", r -> r
                        .path("/scheduler/**")
                        .uri("http://localhost:8082")
                )
                .route("service", r -> r
                        .path("/notification/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
