package com.notification_system.decorator;

/**
 * INotification ek common interface hai jo saare notifications follow karte hain.
 *
 * Ye Decorator Pattern ka base component hai.
 *
 * Is interface ka kaam hai:
 * - Sabhi notifications ke liye ek standard method provide karna: `getContent()`
 * - Decorator classes bhi isi interface ko implement karengi, taaki interchangeable rahein
 */
public interface INotification {

    /**
     * Notification ka final content return karta hai (jo bhi decorate hua ho).
     *
     * Example:
     * - Agar base content "Hello" hai
     * - Aur decorator ne timestamp add kiya ho, to output ho sakta hai:
     *   "Hello [10:30 AM]"
     *
     * @return Final decorated notification content as String
     */
    String getContent();
}
