package com.notification_system.decorator;

/**
 * Ye abstract class decorator pattern ka base hai.
 *
 * Iska kaam hai:
 * - Dusre decorators ko chain ya wrap karna
 * - Content ko modify/add karna without changing original notification
 *
 * Ye class INotification ko implement karti hai, isliye isse treat kiya ja sakta hai jaise ek notification.
 *
 * Real Life Example:
 * Agar base notification "Hello" hai, to ek decorator timestamp jod ke bana sakta hai:
 * "Hello [10:30 AM]", fir emoji decorator jod ke: "Hello [10:30 AM] 😄"
 */
public abstract class NotificationDecorator implements INotification {

    /**
     * Ye reference previous (wrapped) decorator ka hoga.
     *
     * Isse chain create hoti hai jisme har decorator agle wale ke upar kaam karta hai.
     *
     * Example:
     * EmojiDecorator -> TimestampDecorator -> BaseNotification
     */
    protected final NotificationDecorator decorator;

    /**
     * Constructor me dusre decorator ko inject kar rahe hain.
     *
     * @param decorator Ye wo decorator hai jisko hum wrap kar rahe hain (null bhi ho sakta hai agar ye base ho)
     */
    protected NotificationDecorator(NotificationDecorator decorator) {
        this.decorator = decorator;
    }

    /**
     * Har concrete decorator class ko apna getContent() override karna padega.
     *
     * Is method ka kaam hai: pehle ke decorator ka content leke usme kuch naya jodna.
     *
     * @return Decorated content (jaise emoji/timestamp added)
     */
    public abstract String getContent();
}
