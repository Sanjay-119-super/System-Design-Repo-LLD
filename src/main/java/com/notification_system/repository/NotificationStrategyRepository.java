package com.notification_system.repository;

import com.notification_system.model.NotificationStrategyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository NotificationStrategyEntity ke liye CRUD operations provide karti hai.
 *
 * NotificationStrategyEntity system me available saari notification strategies ko represent karta hai,
 * jaise: EMAIL, SMS, POPUP etc.
 *
 * Strategy Design Pattern ke through, ye alag-alag notification channel ko define karta hai.
 *
 * Spring Data JPA automatically iska implementation generate karta hai.
 */
public interface NotificationStrategyRepository extends JpaRepository<NotificationStrategyEntity, Long> {

    // 🔹 Default CRUD methods:
    // - save(), findAll(), findById(), deleteById() etc.

    // ✅ Future me agar specific strategy type se search karna ho to method bana sakte ho:
    // Optional<NotificationStrategyEntity> findByStrategyType(StrategyType type);
}
