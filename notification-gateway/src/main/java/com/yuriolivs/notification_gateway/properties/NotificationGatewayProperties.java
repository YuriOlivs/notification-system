package com.yuriolivs.notification_gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "gateway")
@Data
public class NotificationGatewayProperties {
    private String apiKey;
}
