package strategies;

/**
 * ✅ UpiPaymentStrategy — UPI number ke through payment process karta hai
 *
 * ⚙️ Working:
 * - Constructor ke through UPI ID ya mobile number receive karta hai
 * - `pay()` method me payment simulation print karta hai
 *
 * 💬 Interview Angle:
 * - Strategy Design Pattern ka concrete implementation
 * - Constructor dependency injection ka example
 *
 * ❓ Why?
 * - Har user ka alag UPI ID hota hai, to usko instance level pe store karna zaroori hota hai
 * - Real-world UPI payments me user ID validate aur process hoti hai
 */
public class UpiPaymentStrategy implements PaymentStrategy {

    private String upiNumber;

    /**
     * Constructor — UPI number accept karta hai
     * @param number String — UPI ID ya mobile number
     */
    public UpiPaymentStrategy(String number) {
        this.upiNumber = number;
    }

    /**
     * pay — UPI se payment simulate karta hai
     *
     * @param amount double — jitna amount pay karna hai
     */
    @Override
    public void pay(double amount) {
        // Real implementation me yaha UPI gateway se transaction hota
        System.out.println("📱 Paid ₹" + amount + " via UPI ID: " + upiNumber);
    }
}
