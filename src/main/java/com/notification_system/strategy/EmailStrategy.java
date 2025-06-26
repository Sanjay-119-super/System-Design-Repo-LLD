package com.notification_system.strategy;

import org.springframework.stereotype.Service;

/**
 * Ye class Strategy Pattern ka ek concrete implementation hai.
 *
 * Iska kaam hai notification ko email ke through bhejna.
 * Isme currently sirf console log ho raha hai, lekin real-world me yaha
 * SMTP ya 3rd-party email service (SendGrid, Mailgun, etc.) use hoti hai.
 */
@Service
public class EmailStrategy implements NotificationStrategy {

    /**
     * Email ke through notification send karne ka logic yaha likha jata hai.
     *
     * @param content Ye message body hai jo user ko bhejna hai
     */
    @Override
    public void sendNotification(String content) {
        System.out.println("[EMAIL] Sending: " + content);
    }
}
