package com.yuriolivs.herald.herald_auth.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@ToString
@Table(
    name = "tenants"
)
@NoArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private boolean isActive;

    public Tenant(
            String name,
            boolean isActive
    ) {
        this.name = name;
        this.isActive = isActive;
    }
}
