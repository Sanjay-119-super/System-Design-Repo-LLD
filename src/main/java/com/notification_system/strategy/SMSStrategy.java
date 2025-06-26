package com.notification_system.strategy;

import org.springframework.stereotype.Service;

/**
 * Ye class Strategy Design Pattern ka concrete implementation hai.
 * Iska kaam hai notification content ko SMS ke through bhejna.
 *
 * Filhaal ye sirf console me print karta hai, lekin production me
 * SMS gateways jaise Twilio, Fast2SMS, Msg91, etc. use kiye jaate hain.
 */
@Service
public class SMSStrategy implements NotificationStrategy {

    /**
     * Notification content ko SMS ke form me bhejne ka logic.
     *
     * @param content Ye wo message hai jo user ko SMS ke through bhejna hai
     */
    @Override
    public void sendNotification(String content) {
        System.out.println("[SMS] Sending: " + content);
    }
}
