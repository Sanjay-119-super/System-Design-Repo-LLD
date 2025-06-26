package com.notification_system.repository;

import com.notification_system.model.NotificationDecoratorMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Ye repository NotificationDecoratorMeta entity ke liye
 * database access provide karti hai.
 *
 * Iska kaam hai ye track karna ki:
 * - Kis Notification pe kaun-kaun se decorators lage hue hain
 * - Un decorators ka type kya hai (TIMESTAMP, SIGNATURE, etc.)
 * - Unka actual value kya hai (agar koi config ya value chahiye to)
 */
public interface NotificationDecoratorMetaRepository extends JpaRepository<NotificationDecoratorMeta, Long> {

    /**
     * Ye method ek specific Notification ID ke liye
     * uske saare associated decorators return karta hai.
     *
     * @param notificationId Notification ka ID
     * @return List of NotificationDecoratorMeta jo us Notification pe applied hain
     */
    List<NotificationDecoratorMeta> findByNotificationId(Long notificationId);
}
