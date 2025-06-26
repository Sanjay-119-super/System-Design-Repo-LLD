package strategies;

/**
 * ✅ CreditCardPaymentStrategy — Credit Card ke through payment process karta hai
 *
 * ⚙️ Working:
 * - `pay(double amount)` method ko override karta hai
 * - Simply ek message print karta hai ki amount credit card se pay kiya gaya
 *
 * 💬 Interview Angle:
 * - Strategy Pattern ka real-world example
 * - Concrete class jo PaymentStrategy ko implement karta hai
 *
 * ❓ Why?
 * - Credit Card ek commonly used payment method hai
 * - Har payment method ka apna implementation hona chahiye for better flexibility
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {

    /**
     * pay — Credit card se payment simulate karta hai
     *
     * @param amount double — jitna amount pay karna hai
     */
    @Override
    public void pay(double amount) {
        // Real system me yaha card validation aur gateway logic hota
        System.out.println("💳 Paid ₹" + amount + " via Credit Card.");
    }
}
