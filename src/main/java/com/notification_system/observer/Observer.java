package com.notification_system.observer;

/**
 * Ye interface define karta hai ek Observer ka behavior.
 *
 * Observer Pattern ke according:
 * - Jab bhi koi Observable object change hota hai (event hota hai),
 *   to is interface ko implement karne wali class ka `update()` method call hota hai.
 *
 * Har observer ka update ka response alag ho sakta hai —
 * jaise Email bhejna, SMS karna, ya Log file me save karna.
 */
public interface Observer {

    /**
     * Ye method jab call hota hai tab observer ko koi naya content ya message milta hai.
     *
     * @param content Notification ka content/message jo observer ko mila hai
     */
    void update(String content);
}
