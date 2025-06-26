package com.notification_system.repository;

import com.notification_system.model.ObserverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository ObserverEntity ke liye database access provide karti hai.
 *
 * ObserverEntity system ke un components ko represent karta hai
 * jo kisi observable ke change hone par react karte hain
 * (e.g., Logger, Email sender, SMS sender).
 *
 * Spring Data JPA is interface ka automatic implementation generate karta hai.
 */
public interface ObserverRepository extends JpaRepository<ObserverEntity, Long> {

    // ✅ Default CRUD methods mil jaate hain:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - etc.

    // ✅ Future ke liye agar observer name se search karna ho to:
    // Optional<ObserverEntity> findByName(String name);
}
