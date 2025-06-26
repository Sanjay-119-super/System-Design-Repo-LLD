package factories;

import models.*;
import strategies.PaymentStrategy;

import java.util.List;

/**
 * ✅ ScheduledOrderFactory — Factory Design Pattern ka ek real-world implementation
 *
 * Is class ka kaam hai: aise orders banana jo user ne future ke time ke liye schedule kiye hain.
 * Jaise Zomato mein user bolta hai: "Mujhe shaam 7 baje food chahiye" — ye wahi case handle karta hai.
 *
 * 🔥 Real World Use Case:
 * Zomato mein Scheduled delivery ya Pickup ka option hota hai, jisme user abhi order karta hai
 * lekin delivery baad mein hoti hai (e.g., party ke liye food 2 hours baad chahiye).
 *
 * 🧠 Design Pattern:
 * Factory Pattern use kiya gaya hai to decouple object creation logic from the client.
 * Ye SOLID principles (especially OCP) ko follow karta hai.
 */
public class ScheduledOrderFactory implements OrderFactory {

    // 🔸 Ye wo time hai jab user chah raha hai ki order deliver ya pickup ho (future time)
    private String scheduledTime;

    // ✅ Constructor ke through scheduledTime inject kiya jaata hai
    public ScheduledOrderFactory(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    /**
     * 🔁 createOrder Method — ek scheduled order banata hai (Delivery ya Pickup)
     *
     * @param user - jisne order kiya
     * @param cart - user ka cart (optional: future mein useful ho sakta hai)
     * @param restaurant - jahan se order aa raha hai
     * @param menuItems - order mein jo khana hai
     * @param paymentStrategy - kaunsa payment mode use hua hai (UPI/Card/Cash etc.)
     * @param totalCost - final order cost
     * @param orderType - "Delivery" ya "Pickup"
     *
     * @return Order - ek scheduled order (delivery ya pickup type) return karega
     *
     * 🧠 Interview Tip:
     * - Scheduling ke liye ek field injected hai via constructor (great for flexibility)
     * - Order creation logic runtime pe decide hota hai based on `orderType`
     */
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant,
                             List<MenuItems> menuItems, PaymentStrategy paymentStrategy,
                             double totalCost, String orderType) {

        Order order = null;

        // 🔄 Check orderType aur uske according order object banaao
        if (orderType.equalsIgnoreCase("Delivery")) {  // 🛠️ Case-insensitive match
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());  // 📦 Address jahan delivery honi hai
            order = deliveryOrder;
        } else {
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestaurantAddress(restaurant.getLocation());  // 📍 Pickup location
            order = pickUpOrder;
        }

        // ✅ Common fields har order ke liye
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduledTime);  // 🕒 User-specified time
        order.setTotal(totalCost);

        return order;
    }
}
