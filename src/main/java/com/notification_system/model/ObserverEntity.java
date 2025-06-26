package com.notification_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Ye entity ek Observer ko represent karti hai
 * jo kisi observable (notification) ko listen karta hai.
 *
 * Observer Pattern ke mutabik:
 * - Observer wahi component hota hai jo notify hone par action leta hai.
 * - Jaise: EmailService, SMSService, WhatsAppClient, PushNotificationHandler, etc.
 */
@Entity
public class ObserverEntity {

    /**
     * Auto-generated primary key for each observer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Observer ka naam (jaise: EmailService, SMSClient, etc.)
     */
    private String name;

    // ---------------- Constructors ----------------

    public ObserverEntity() {
        // Default constructor for JPA
    }

    public ObserverEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "ObserverEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
