package com.notification_system.model;

import javax.persistence.*;

/**
 * Ye entity decorator metadata ko represent karti hai jo batata hai:
 * - Kaunsa notification decorate hona chahiye
 * - Kaunse type ka decorator apply hoga (TIMESTAMP, SIGNATURE)
 * - Kya value jodni hai (e.g., custom signature text)
 *
 * Ye system ko flexible banata hai kyunki decorators DB se dynamically apply ho sakte hain.
 */
@Entity
public class NotificationDecoratorMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Ye value wo specific data hai jo decorator use karega.
     * Example: decoratorValue = "Signed by Admin", "Time: 10:30"
     */
    private String decoratorValue;

    /**
     * Ye decorator kis notification ke liye apply hoga.
     */
    @ManyToOne
    private Notification notification;

    /**
     * ENUM type batata hai kaunsa decorator lagana hai.
     * Example: TIMESTAMP, SIGNATURE
     *
     * Isse future me aur decorator types add kar sakte ho (jaise EMOJI, PRIORITY)
     */
    @Enumerated(EnumType.STRING)
    private DecoratorType decoratorType;

    // ------------- ENUM Definition -------------
    public enum DecoratorType {
        TIMESTAMP,
        SIGNATURE
    }

    // ------------- Constructors -------------

    public NotificationDecoratorMeta() {
        // JPA ke liye default constructor
    }

    public NotificationDecoratorMeta(long id, String decoratorValue, Notification notification, DecoratorType decoratorType) {
        this.id = id;
        this.decoratorValue = decoratorValue;
        this.notification = notification;
        this.decoratorType = decoratorType;
    }

    // ------------- Getters & Setters -------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDecoratorValue() {
        return decoratorValue;
    }

    public void setDecoratorValue(String decoratorValue) {
        this.decoratorValue = decoratorValue;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public DecoratorType getDecoratorType() {
        return decoratorType;
    }

    public void setDecoratorType(DecoratorType decoratorType) {
        this.decoratorType = decoratorType;
    }

    // ------------- toString() -------------

    @Override
    public String toString() {
        return "NotificationDecoratorMeta{" +
                "id=" + id +
                ", decoratorValue='" + decoratorValue + '\'' +
                ", notification=" + notification +
                ", decoratorType=" + decoratorType +
                '}';
    }
}
