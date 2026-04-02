package com.yuriolivs.herald_service.telegram.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TelegramMessageDTO(
    @NotBlank
    String idempotencyKey,

    @NotBlank
    Long userId,

    @NotBlank
    @Size(max = 255, min = 3)
    String message
) {}
