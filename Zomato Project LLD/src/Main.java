import models.Order;
import models.Restaurant;
import models.User;
import strategies.UpiPaymentStrategy;

/**
 * ✅ Main — Zomato-style app ka happy flow simulate karta hai
 *
 * ⚙️ Flow:
 * 1. User create hota hai
 * 2. User restaurant search karta hai
 * 3. Restaurant select hota hai
 * 4. Cart me items add hote hain
 * 5. Checkout hota hai with DeliveryOrder
 * 6. Payment hota hai via UPI
 * 7. NotificationService se confirmation milti hai
 *
 * 💬 Interview Angle:
 * - Ye flow MVC ya layered architecture ka ek simulation hai
 * - Code readability, flow control aur object interactions dikhaye gaye hain
 * - Ideal for LLD explanation in interviews
 *
 * ❓ Why?
 * - Happy Flow har app ke testing aur demo ke liye essential hota hai
 * - Real-world user interaction ka step-by-step structure dikhata hai
 */
public class Main {
    public static void main(String[] args) {

        // 🛠 Step 1: App & User Create
        TomatoApp tomatoApp = new TomatoApp();
        User user = new User(101, "Sanjay Kumar", "is active");

        // 🔍 Step 2: Search Restaurant
        java.util.List<Restaurant> restaurantList = tomatoApp.searchRestaurant("Jaipur");

        if (restaurantList.isEmpty()) {
            System.out.println("❌ No restaurant found in your location.");
            return;
        }

        System.out.println("✅ Found Restaurant(s):");
        for (Restaurant restaurant : restaurantList) {
            System.out.println("- " + restaurant.getName());
        }

        // 🍽 Step 3: Select Restaurant
        Restaurant selectedRestaurant = restaurantList.get(0);
        tomatoApp.selectRestaurant(user, selectedRestaurant);
        System.out.println("🛒 Selected Restaurant: " + selectedRestaurant.getName());

        // 🍔 Step 4: Add Items to Cart
        tomatoApp.addToCart(user, "P1"); // assume P1 and P2 are menu codes
        tomatoApp.addToCart(user, "P2");

        // 📦 Step 5: View Cart
        tomatoApp.printUserCart(user);

        // ✅ Step 6: Checkout
        Order order = tomatoApp.checkOutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));
        if (order == null) {
            System.out.println("❌ Order creation failed.");
            return;
        }

        // 💳 Step 7: Pay for Order
        tomatoApp.payForOrder(user, order); // internally notifies after success
    }
}
