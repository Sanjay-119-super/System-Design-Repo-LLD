package com.notification_system.observer;

/**
 * Ye interface define karta hai ki koi bhi object Observable ban sakta hai —
 * jise multiple Observers observe kar sakte hain.
 *
 * Ye interface Observer Pattern ka core part hai.
 * Jab bhi koi event hota hai (jaise: notification trigger),
 * to observers ko notify kiya jaata hai.
 */
public interface Observable {

    /**
     * Is method ka use ek observer ko add karne ke liye hota hai.
     *
     * @param observer Observer instance jo is observable ko observe karega
     */
    void addObserver(Observer observer);

    /**
     * Is method se koi observer remove kiya ja sakta hai
     * agar usse notifications nahi chahiye.
     *
     * @param observer Observer instance jo remove karna hai
     */
    void removeObserver(Observer observer);

    /**
     * Jab koi event hota hai, to ye method sab registered observers ko notify karta hai.
     *
     * @param content Jo message ya notification observers ko bhejna hai
     */
    void notifyObserver(String content);
}
