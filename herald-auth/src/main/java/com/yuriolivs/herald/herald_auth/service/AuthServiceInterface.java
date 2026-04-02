package com.yuriolivs.herald.herald_auth.service;

import com.yuriolivs.herald.herald_auth.domain.entities.Tenant;

import java.util.UUID;

public interface AuthServiceInterface {
    Tenant validateApiKey(String key);
    Tenant createTenant(String name);
    String generateApiKey(UUID id);
    String revokeApiKey(String key);
}
