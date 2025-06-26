package com.notification_system.strategy;

import org.springframework.stereotype.Service;

/**
 * Ye class Strategy Pattern ka ek concrete implementation hai jo
 * user ko popup ke form me notification dikhata hai.
 *
 * Filhal ye console me log karta hai, but real project me
 * front-end ke sath WebSocket ya notification API use ki ja sakti hai.
 */
@Service
public class POPUPStrategy implements NotificationStrategy {

    /**
     * Ye method popup ke zariye notification show karta hai.
     * Yaha currently sirf console me dikhaya ja raha hai.
     *
     * @param content Notification message jo dikhana hai user ko
     */
    @Override
    public void sendNotification(String content) {
        System.out.println("[POPUP] Showing: " + content);
    }
}
