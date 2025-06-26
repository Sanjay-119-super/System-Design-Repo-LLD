package com.notification_system.model;

import javax.persistence.*;

/**
 * Notification entity system ka base message represent karti hai.
 *
 * Iska kaam hai:
 * - Ek raw notification content store karna (jaise: "Server down at 3 AM")
 * - Ye message baad me decorate (timestamp, emoji) ya deliver (via observer) kiya jaa sakta hai
 */
@Entity
public class Notification {

    /**
     * Auto-generated primary key ID for each notification.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Actual message content of the notification.
     * Example: "Your OTP is 123456", "Meeting at 4 PM", etc.
     */
    private String content;

    // ---------------- Constructors ----------------

    public Notification() {
        // Default constructor required by JPA
    }

    public Notification(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
