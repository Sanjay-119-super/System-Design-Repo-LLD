package com.notification_system.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Ye entity notification system ke andar hone wale events ya messages ka log banati hai.
 *
 * Iska main kaam hai:
 * - System ke actions ko record karna (jaise "SMS sent", "Observer attached", etc.)
 * - Kis observable ke liye log hai, wo bhi track karna
 * - Timestamp ke saath store karna taaki audit/troubleshooting easy ho
 */
@Entity
public class LoggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ye message field hai jisme log ka content hota hai.
     * Example: "WhatsApp sent successfully" ya "Observer mapped to Observable"
     */
    private String message;

    /**
     * Ye timestamp batata hai ki log kab generate hua tha.
     */
    private Timestamp longTime;

    /**
     * Ye log kis observable se related hai uska reference.
     * Many logs ek observable se linked ho sakte hain.
     */
    @ManyToOne
    private NotificationObservableEntity observableEntity;

    // ---------------- Constructors ----------------

    public LoggerEntity() {
        // Default constructor required for JPA
    }

    public LoggerEntity(long id, String message, Timestamp longTime, NotificationObservableEntity observableEntity) {
        this.id = id;
        this.message = message;
        this.longTime = longTime;
        this.observableEntity = observableEntity;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getLongTime() {
        return longTime;
    }

    public void setLongTime(Timestamp longTime) {
        this.longTime = longTime;
    }

    public NotificationObservableEntity getObservableEntity() {
        return observableEntity;
    }

    public void setObservableEntity(NotificationObservableEntity observableEntity) {
        this.observableEntity = observableEntity;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "LoggerEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", longTime=" + longTime +
                ", observableEntity=" + observableEntity +
                '}';
    }
}
