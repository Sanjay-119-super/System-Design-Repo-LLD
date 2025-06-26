package com.notification_system.service;

/**
 * Ye class ek Singleton Pattern ka implementation hai.
 *
 * Iska main purpose hai system ke andar sirf ek hi instance maintain karna,
 * taaki shared logging ya notification service ek centralized object ke through ho.
 *
 * ➤ Example use-case: Central log service, audit, in-memory notification cache etc.
 */
public class NotificationService {

    // static instance jo singleton object store karega
    private static NotificationService instance;

    // private constructor: koi bahar se object create na kar sake
    private NotificationService() {
    }

    /**
     * Singleton instance return karta hai.
     * Thread-safe bhi hai due to synchronized keyword.
     *
     * @return NotificationService ka ek hi shared instance
     */
    public static synchronized NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    /**
     * Ye method log message print karta hai.
     * Sirf testing/demo purpose ke liye hai. Production me SLF4J logger use hota hai.
     *
     * @param sms Ye woh message hai jo log karna hai
     */
    public void log(String sms) {
        System.out.println("[Singleton notification service]: " + sms);
    }
}
