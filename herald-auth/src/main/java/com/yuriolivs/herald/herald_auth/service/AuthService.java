package com.yuriolivs.herald.herald_auth.service;

import com.yuriolivs.herald.herald_auth.domain.dto.request.*;
import com.yuriolivs.herald.herald_auth.domain.entities.ApiKey;
import com.yuriolivs.herald.herald_auth.domain.entities.Tenant;
import com.yuriolivs.herald.herald_auth.repository.ApiKeyRepository;
import com.yuriolivs.herald.herald_auth.repository.TenantRepository;
import com.yuriolivs.herald.herald_auth.security.converter.EncryptionConverter;
import com.yuriolivs.herald.shared.exceptions.http.HttpBadRequestException;
import com.yuriolivs.herald.shared.exceptions.http.HttpNotFoundException;
import com.yuriolivs.herald.shared.exceptions.http.HttpUnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceInterface{
    private EncryptionConverter converter;
    private TenantRepository tenantRepo;
    private ApiKeyRepository keyRepo;

    @Override
    public Tenant validateApiKey(ApiKeyValidateRequest dto) {
        String key = dto.apiKey();
        String hashedKey = converter.convertToDatabaseColumn(key);

        Optional<ApiKey> keyFound = keyRepo.findByKey(hashedKey);
        if (keyFound.isEmpty() || !keyFound.get().isActive())
            throw new HttpUnauthorizedException("Invalid API Key");

        Optional<Tenant> tenantFound = tenantRepo.findById(keyFound.get().getTenantId());
        if (tenantFound.isEmpty() || !tenantFound.get().isActive())
            throw new HttpUnauthorizedException("Invalid API Key");

        return tenantFound.get();
    }

    @Override
    public Tenant createTenant(CreateTenantRequest dto) {
        String tenantName = dto.name();
        Tenant tenantToBeCreated = new Tenant(tenantName, true);

        return tenantRepo.save(tenantToBeCreated);
    }

    @Override
    public String generateApiKey(GenerateApiKeyRequest dto) {
        return "";
    }

    @Override
    public String revokeApiKey(RevokeApiKeyRequest dto) {
        String key = dto.apiKey();
        String hashedKey = converter.convertToDatabaseColumn(key);

        Optional<ApiKey> keyFound = keyRepo.findByKey(hashedKey);
        if (keyFound.isEmpty())
            throw new HttpNotFoundException("Key not found");

        ApiKey keyToInactivate = keyFound.get();

        if (keyToInactivate.isActive()) {
            keyToInactivate.setActive(false);
            keyRepo.save(keyToInactivate);
        }

        return "Key deactivated successfully";
    }

    @Override
    public String revokeTenantKeys(RevokeTenantKeysRequest dto) {
        Optional<Tenant> tenanFound = tenantRepo.findById(dto.tenantId());
        if (tenanFound.isEmpty())
            throw new HttpNotFoundException("Tenant not found");

        List<ApiKey> keys = keyRepo.findAllByTenantId(tenanFound.get().getId());
        if (keys.isEmpty())
            throw new HttpNotFoundException("No keys found");

        keys.forEach(key -> key.setActive(false));

        keyRepo.saveAll(keys);

        return "All tenant keys were deactivated";
    }
}
