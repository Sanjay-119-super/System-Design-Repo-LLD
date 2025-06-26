package com.notification_system.model;

import javax.persistence.*;

/**
 * Ye entity NotificationEngine aur NotificationStrategy ke beech mapping ko represent karti hai.
 *
 * Iska kaam hai:
 * - Kaunsa engine kis strategy ka use karega, wo define karna
 * - Strategy pattern ko dynamic banane ke liye is table ka use hota hai
 *
 * Real world example:
 * EmailEngine → RetryStrategy
 * WhatsAppEngine → InstantSendStrategy
 */
@Entity
public class EngineStrategyMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * NotificationEngineEntity ke saath many-to-one mapping
     *
     * Ek engine multiple strategy maps me repeat ho sakta hai (jaise EmailEngine ke liye different strategies)
     */
    @ManyToOne
    private NotificationEngineEntity engine;

    /**
     * NotificationStrategyEntity ke saath many-to-one mapping
     *
     * Ek strategy multiple engines me use ho sakti hai
     */
    @ManyToOne
    private NotificationStrategyEntity strategy;

    // Default constructor (JPA ke liye zaroori hota hai)
    public EngineStrategyMap() {
    }

    /**
     * All-args constructor (custom object banate waqt useful hota hai)
     */
    public EngineStrategyMap(long id, NotificationEngineEntity engine, NotificationStrategyEntity strategy) {
        this.id = id;
        this.engine = engine;
        this.strategy = strategy;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NotificationEngineEntity getEngine() {
        return engine;
    }

    public void setEngine(NotificationEngineEntity engine) {
        this.engine = engine;
    }

    public NotificationStrategyEntity getStrategy() {
        return strategy;
    }

    public void setStrategy(NotificationStrategyEntity strategy) {
        this.strategy = strategy;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "EngineStrategyMap{" +
                "id=" + id +
                ", engine=" + engine +
                ", strategy=" + strategy +
                '}';
    }
}
