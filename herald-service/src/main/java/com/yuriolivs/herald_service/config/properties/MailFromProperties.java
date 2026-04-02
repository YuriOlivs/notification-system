package com.yuriolivs.herald_service.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail.from")
@Getter
@Setter
public class MailFromProperties {
    private String address;
    private String name;
}
