package strategies;

/**
 * ✅ PaymentStrategy — Strategy Design Pattern ka interface jo payment methods ko abstract karta hai
 *
 * ⚙️ Working:
 * - `pay` method ko implement karke alag-alag payment methods define kiye ja sakte hain
 * - Jaise CreditCardPayment, UpiPayment, WalletPayment, etc.
 *
 * 💬 Interview Angle:
 * - Strategy pattern ka perfect example hai
 * - Open/Closed Principle ko follow karta hai (naye payment methods add karne ke liye code modify nahi karna padta)
 * - Loose coupling maintain karta hai between Order and Payment logic
 *
 * ❓ Why?
 * - Real apps me multiple payment methods hote hain
 * - Hardcoded `if-else` se bachne ke liye abstraction use karte hain
 * - Payment logic change hone par sirf naya class banana hota hai, existing code untouched rehta hai
 */
public interface PaymentStrategy {

    /**
     * pay - Diya gaya amount process karta hai
     *
     * @param amount double value jo pay karni hai
     */
    void pay(double amount);
}
