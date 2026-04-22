package com.yuriolivs.herald_gateway.client;

import com.yuriolivs.herald.shared.domain.auth.ApiKeyValidate;
import com.yuriolivs.herald.shared.domain.auth.CreateTenantResponse;
import com.yuriolivs.herald_gateway.config.properties.RoutingProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AuthClient {
    private final RestTemplate restTemplate;
    private final RoutingProperties routes;

    public CreateTenantResponse validateKey(String key) {
        String uri = routes.getAuth() + "/api-key/validate";

        ApiKeyValidate keyValidate = ApiKeyValidate.builder()
                .apiKey(key)
                .build();

        return restTemplate.postForObject(
                uri,
                keyValidate,
                CreateTenantResponse.class
        );
    }
}
