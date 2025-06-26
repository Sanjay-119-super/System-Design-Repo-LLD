package factories;

import models.*;
import strategies.PaymentStrategy;
import utils.TimeUtils;

import java.util.List;

/**
 * NowOrderFactory ek Factory class hai jo turant ("Now") order create karta hai.
 * Yeh Factory design pattern follow karta hai — jisme Order type ke object banate hain
 * bina client ko exact implementation jaane hue.
 *
 * Yeh delivery ya pickup type order dono bana sakta hai.
 */
public class NowOrderFactory implements OrderFactory {

    /**
     * createOrder method ek naya Order object banata hai - delivery ya pickup type ke hisaab se.
     *
     * @param user - jisne order place kiya
     * @param cart - user ka cart (optional, agar future mein cart se mapping chahiye ho)
     * @param restaurant - jahan se food order ho raha hai
     * @param menuItems - jo items user ne order kiye
     * @param paymentStrategy - kaunsa payment method use kiya gaya (Card/UPI/Cash etc.)
     * @param totalCost - final cost of order
     * @param orderType - "Delivery" ya "Pickup"
     * @return Order - return karta hai valid Order object
     */
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItems> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {

        // Null object banaya, baad mein type check karke assign karenge
        Order order = null;

        // "Delivery" type ke liye DeliveryOrder object banega
        if (orderType.equalsIgnoreCase("Delivery")) {  // 🛠️ Used equalsIgnoreCase for case-insensitive comparison
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress()); // Set user address for delivery
            order = deliveryOrder;
        } else {
            // Otherwise pickup order banega
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestaurantAddress(restaurant.getLocation()); // Restaurant address pickup ke liye
            order = pickUpOrder;
        }

        // ✅ Common attributes sabhi orders ke liye
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime()); // Current time pe scheduled
        order.setTotal(totalCost);

        return order;
    }
}
