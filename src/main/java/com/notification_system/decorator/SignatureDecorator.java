package com.notification_system.decorator;

/**
 * Ye decorator notification ke content ke end me ek fixed signature add karta hai.
 *
 * Real-world example:
 * - Base Content: "Your OTP is 1234"
 * - After SignatureDecorator: "Your OTP is 1234 [Signed by system]"
 *
 * Iska use aise cases me hota hai jahan notifications verify ya authorize ki gayi ho system ke through.
 */
public class SignatureDecorator extends NotificationDecorator {

    /**
     * Constructor jo previous decorator (ya base notification) ko wrap karta hai.
     *
     * @param decorator Ye INotification type ka object hai jise hum decorate karna chahte hain.
     *                  Isme ya to koi aur decorator ho sakta hai, ya base notification bhi ho sakta hai.
     */
    public SignatureDecorator(INotification decorator) {
        super((NotificationDecorator) decorator); // Typecast zaroori hai kyunki parent class NotificationDecorator hai
    }

    /**
     * Ye method decorated content return karta hai.
     *
     * Pehle ke decorator ka content fetch karta hai, aur uske end me "[Signed by system]" jod deta hai.
     *
     * @return Fully decorated content (previous content + signature)
     */
    @Override
    public String getContent() {
        return decorator.getContent() + " [Signed by system]";
    }
}
