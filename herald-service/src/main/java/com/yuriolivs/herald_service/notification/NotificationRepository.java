package com.yuriolivs.herald_service.notification;

import com.yuriolivs.herald_service.notification.domain.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    Optional<Notification> findByIdempotencyKey(String idempotencyKey);
    List<Notification> findAllById(Iterator<UUID> ids);
}
