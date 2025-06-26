package com.notification_system.model;

import javax.persistence.*;

/**
 * Ye entity ek observable ko represent karti hai jise multiple observers subscribe kar sakte hain.
 *
 * Iska kaam hai:
 * - Ek notification ko observable ke form me wrap karna
 * - Observer pattern ke flow me act as "Subject" karna
 *
 * Real-world:
 * Agar "New Product Launch" ek notification hai, to wo observable banega,
 * aur subscribed observers (jaise: EmailService, WhatsAppService) notify honge.
 */
@Entity
public class NotificationObservableEntity {

    /**
     * Auto-generated primary key for observable.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ye observable kis notification se linked hai.
     * One-to-one mapping: ek observable ke paas ek hi base notification hota hai.
     */
    @OneToOne
    private Notification notification;

    // ---------------- Constructors ----------------

    public NotificationObservableEntity() {
        // JPA ke liye default constructor
    }

    public NotificationObservableEntity(long id, Notification notification) {
        this.id = id;
        this.notification = notification;
    }

    // ---------------- Getters and Setters ----------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    // ---------------- toString() ----------------

    @Override
    public String toString() {
        return "NotificationObservableEntity{" +
                "id=" + id +
                ", notification=" + notification +
                '}';
    }
}
