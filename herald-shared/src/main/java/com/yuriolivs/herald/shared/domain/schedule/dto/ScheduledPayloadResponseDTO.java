package com.yuriolivs.herald.shared.domain.schedule.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ScheduledPayloadResponseDTO(
        @NotNull
        List<SchedulePayloadDTO> list
) {}
