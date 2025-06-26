package factories;

import models.*;
import strategies.PaymentStrategy;

import java.util.List;

/**
 * ✅ OrderFactory Interface — Pure Real-World Use Case
 *
 * Ye ek Factory Design Pattern ka part hai, jiska kaam hota hai:
 * 🔸 Different types of Order (e.g., Delivery, Pickup, Scheduled) banane ke liye ek common blueprint dena.
 * 🔸 Har Order type ke liye aap alag-alag factory classes bana sakte ho, jo yeh interface implement karein.
 *
 * 🔥 Real World Analogy:
 * Zomato app mein order karte waqt user decide karta hai — "abhi chahiye (Now)", ya "baad mein chahiye (Scheduled)".
 * Dono cases mein kuch attributes same hote hain, lekin kuch cheeze alag hoti hain.
 * Factory pattern ka use karke hum code ko reusable, maintainable aur scalable bana paate hain.
 *
 * ✅ Interface ka faayda:
 * - Loose coupling (code independent rehta hai)
 * - Easy to extend (naye order types add karna easy hota hai)
 * - SOLID Principle follow karta hai (O - Open/Closed Principle)
 */
public interface OrderFactory {

    /**
     * ✅ createOrder Method — har factory ko yeh method implement karna hoga.
     *
     * Ye method har order ke liye important information accept karta hai, jaise:
     *
     * @param user           🔸 Order place karne wala user (User object)
     * @param cart           🔸 User ka cart (optional: future use ke liye jaise discounts, promo calculation)
     * @param restaurant     🔸 Jis restaurant se food aa raha hai (Restaurant object)
     * @param menuItems      🔸 Kaunse items order kiye gaye (List of MenuItems)
     * @param paymentStrategy🔸 Kaunse payment mode ka use kiya gaya (UPI/Card/Cash etc.) — Strategy pattern use ho raha hai yahan
     * @param totalCost      🔸 Final total price (discounts ke baad bhi ho sakta hai)
     * @param orderType      🔸 "Delivery" ya "Pickup" — kis type ka order hai
     *
     * @return Order         🔁 Return karta hai ek valid Order object (either DeliveryOrder ya PickUpOrder)
     *
     * 🔥 Interviewer Tip:
     * - Yeh ek abstraction layer hai jisse hum runtime pe order object decide kar sakte hain.
     * - Yahan se directly object creation ka control hata diya gaya hai (good practice).
     */
    Order createOrder(User user, Cart cart, Restaurant restaurant,
                      List<MenuItems> menuItems, PaymentStrategy paymentStrategy,
                      double totalCost, String orderType);
}
