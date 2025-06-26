package com.notification_system.observer;

import com.notification_system.model.LoggerEntity;
import com.notification_system.repository.LoggerRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * LoggerObserver ek concrete observer hai jo notification ke content ko
 * database me log karta hai jab bhi update() method call hota hai.
 *
 * Iska main use hai:
 * - Notifications ko log karna for debugging/auditing
 * - Real-time history maintain karna
 */
@Component
public class LoggerObserver implements Observer {

    private final LoggerRepository repository;

    /**
     * LoggerRepository inject hota hai jisse log entries save ki ja sakti hain DB me.
     *
     * @param repository LoggerRepository (Spring Data JPA repository)
     */
    public LoggerObserver(LoggerRepository repository) {
        this.repository = repository;
    }

    /**
     * Ye method observer pattern ke through call hota hai
     * jab koi observable notify karta hai is observer ko.
     *
     * @param content notification ka actual content (String) jo log me store hoga
     */
    @Override
    public void update(String content) {
        // Naya LoggerEntity banate hain
        LoggerEntity log = new LoggerEntity();
        log.setMessage(content); // Notification message
        log.setLongTime(new Timestamp(System.currentTimeMillis())); // Current timestamp

        // DB me save karna
        repository.save(log);

        // Console output for visibility
        System.out.println("[LOGGER] logged: " + content);
    }
}
