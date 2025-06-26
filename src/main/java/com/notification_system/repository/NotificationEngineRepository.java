package com.notification_system.repository;

import com.notification_system.model.NotificationEngineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository NotificationEngineEntity ke liye data access layer provide karti hai.
 *
 * NotificationEngineEntity ek engine object hota hai jo ek observable ke sath linked hota hai.
 * Aur ye engine multiple strategies (SMS, EMAIL, etc.) ko fire karta hai jab bhi notify hota hai.
 *
 * Is interface me Spring Data JPA automatically basic CRUD methods provide karta hai:
 * - save(), findById(), findAll(), deleteById(), etc.
 */
public interface NotificationEngineRepository extends JpaRepository<NotificationEngineEntity, Long> {
    // Abhi ke liye default CRUD methods sufficient hain.

    // Future ke liye agar observable ke basis pe engine fetch karna ho,
    // to aise method add kiya ja sakta hai:
    // Optional<NotificationEngineEntity> findByObservableEntityId(Long observableId);
}
