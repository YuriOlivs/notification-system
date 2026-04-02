package com.yuriolivs.herald.herald_auth.service;

import com.yuriolivs.herald.herald_auth.domain.entities.Tenant;
import com.yuriolivs.herald.herald_auth.repository.AuthRepository;
import com.yuriolivs.herald.herald_auth.security.converter.EncryptionConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceInterface{
    private EncryptionConverter converter;
    private AuthRepository repo;

    @Override
    public Tenant validateApiKey(String key) {
        return null;
    }

    @Override
    public Tenant createTenant(String name) {
        return null;
    }

    @Override
    public String generateApiKey(UUID id) {
        return "";
    }

    @Override
    public String revokeApiKey(String key) {
        return "";
    }
}
