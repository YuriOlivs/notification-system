package com.yuriolivs.herald_scheduler.config.properties;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security")
@RequiredArgsConstructor
@Data
public class SecurityProperties {
    private String internalKey;
}
