package com.notification_system.decorator;

import com.notification_system.model.Notification;

/**
 * SimpleNotification ek base notification class hai jo actual notification content hold karti hai.
 *
 * Ye class decorator chain ka starting point hoti hai.
 *
 * Iska kaam hai:
 * - Sirf raw content return karna (bina kisi extra decoration ke)
 * - Ye decorators ke liye base ban jata hai jise wrap karke hum extra info jod sakte hain
 *
 * Real-world example:
 * - Base message: "Server down at 3 AM"
 * - Uske baad decorators lag sakte hain (Timestamp, Emoji, Signature, etc.)
 */
public class SimpleNotification implements INotification {

    // Notification ka actual plain text content
    private String content;

    /**
     * Constructor me base content set kiya jaata hai.
     *
     * @param content Plain notification text (without any decorations)
     */
    public SimpleNotification(String content) {
        this.content = content;
    }

    /**
     * getContent() ka kaam hai plain/original content return karna
     *
     * @return Base notification message (string format me)
     */
    @Override
    public String getContent() {
        return content;
    }
}
