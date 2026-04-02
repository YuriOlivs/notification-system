package com.yuriolivs.herald.herald_auth.domain.entities;

import com.yuriolivs.herald.herald_auth.security.converter.EncryptionConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(
        name = "api_keys"
)
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID tenantId;

    @Convert(converter = EncryptionConverter.class)
    private String key;

    private boolean active;

    public ApiKey(
        UUID tenantId,
        String key,
        boolean active
    ) {
        this.tenantId = tenantId;
        this.key = key;
        this.active = active;
    }
}
