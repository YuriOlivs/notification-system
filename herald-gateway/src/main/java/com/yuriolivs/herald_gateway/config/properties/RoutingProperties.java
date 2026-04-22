package com.yuriolivs.herald_gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "herald.routes")
@Data
public class RoutingProperties {
    private String service;
    private String scheduler;
    private String webhooks;
    private String auth;
}
