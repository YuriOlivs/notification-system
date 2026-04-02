package com.yuriolivs.herald_gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gateway")
@Data
public class NotificationGatewayProperties {
    private String apiKey;
}
