package com.notification_system.repository;

import com.notification_system.model.NotificationObservableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository NotificationObservableEntity ke liye
 * database access (CRUD operations) provide karti hai.
 *
 * NotificationObservableEntity ek "observable" object hota hai
 * jo kisi Notification ke around bana hota hai.
 *
 * Jab observable trigger hota hai, to observers ko notify kiya jata hai.
 *
 * Spring Data JPA is interface ka automatic implementation provide karta hai.
 */
public interface NotificationObservableRepository extends JpaRepository<NotificationObservableEntity, Long> {
    // By default CRUD operations available hote hain:
    // - save(), findById(), findAll(), deleteById(), etc.

    // Future me agar observable ko notificationId se fetch karna ho:
    // Optional<NotificationObservableEntity> findByNotificationId(Long notificationId);
}
