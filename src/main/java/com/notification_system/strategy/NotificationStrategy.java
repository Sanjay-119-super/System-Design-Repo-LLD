package com.notification_system.strategy;

/**
 * Strategy Design Pattern ka core interface.
 *
 * Ye interface ek common contract provide karta hai har tarah ke notification ke liye
 * (jaise Email, SMS, Popup). Har strategy is interface ko implement karti hai.
 */
public interface NotificationStrategy {

    /**
     * Har specific notification medium (email, sms, etc.) apna custom logic is method me likhega.
     *
     * @param content Notification ka content/message jo bhejna hai
     */
    void sendNotification(String content);
}
