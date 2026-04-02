package com.yuriolivs.herald_service.telegram.domain.dto.message;

import jakarta.validation.constraints.NotEmpty;

public record MessageFromDTO(
    @NotEmpty
    Long id
) {}
