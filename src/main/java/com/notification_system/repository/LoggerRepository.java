package com.notification_system.repository;

import com.notification_system.model.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ye repository LoggerEntity ke liye database operations perform karti hai.
 *
 * LoggerEntity har notification ya event ka ek log record hota hai,
 * jise system me debugging, monitoring ya auditing ke purpose se store kiya jaata hai.
 *
 * Spring Data JPA automatically iska implementation generate karta hai.
 */
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long> {
    // Abhi ke liye default CRUD operations sufficient hain:
    // - save(), findById(), findAll(), deleteById(), etc.

    // Future me agar specific queries chahiye (e.g., find by date range),
    // to yaha custom methods ya @Query likhe ja sakte hain.
}
