package com.yuriolivs.herald.herald_auth.service;

import com.yuriolivs.herald.herald_auth.domain.dto.request.*;
import com.yuriolivs.herald.herald_auth.domain.entities.Tenant;

public interface AuthServiceInterface {
    Tenant validateApiKey(ApiKeyValidateRequest dto);
    Tenant createTenant(CreateTenantRequest dto);
    String generateApiKey(GenerateApiKeyRequest dto);
    String revokeApiKey(RevokeApiKeyRequest dto);
    String revokeTenantKeys(RevokeTenantKeysRequest dto);
}
