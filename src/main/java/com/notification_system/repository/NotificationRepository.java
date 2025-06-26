package com.notification_system.repository;

import com.notification_system.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository Notification entity ke liye CRUD operations handle karti hai.
 *
 * Notification object basic message ya content ko represent karta hai
 * jise user ko bhejna hota hai (jaise "Payment Successful", "OTP Sent", etc.).
 *
 * Is interface ke through hum notification create, read, update, delete kar sakte hain.
 *
 * Spring Data JPA is interface ka automatic implementation provide karta hai.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // ✅ Default CRUD methods:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - etc.

    // ✅ Future me agar content based search chahiye:
    // List<Notification> findByContentContainingIgnoreCase(String keyword);
}
