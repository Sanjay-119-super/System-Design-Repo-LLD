package com.notification_system.decorator;

import java.time.Instant;

/**
 * Ye decorator notification ke content ke end me current timestamp add karta hai.
 *
 * Real-world use-case:
 * - Aapko user ko batana hai ki notification kis time pe bheja gaya tha.
 *
 * Example:
 * - Input (base content): "Server down"
 * - Output after decoration: "Server down [Time: 2025-06-26T11:45:23Z]"
 */
public class TimeStampDecorator extends NotificationDecorator {

    /**
     * Constructor me previous notification (ya decorator) pass karte hain.
     *
     * @param notification Ye INotification type ka object hai jise hum decorate karna chahte hain.
     */
    public TimeStampDecorator(INotification notification) {
        super((NotificationDecorator) notification); // Typecast required since parent expects NotificationDecorator
    }

    /**
     * Pehle decorator ka content fetch karta hai, fir uske aakhir me timestamp jod deta hai.
     *
     * @return Final content string with current timestamp
     */
    @Override
    public String getContent() {
        return decorator.getContent() + " [Time: " + Instant.now() + "]";
    }
}
