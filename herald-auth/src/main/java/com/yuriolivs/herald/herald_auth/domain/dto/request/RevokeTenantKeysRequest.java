package com.yuriolivs.herald.herald_auth.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RevokeTenantKeysRequest(
        @NotBlank
        UUID tenantId
) {
}
