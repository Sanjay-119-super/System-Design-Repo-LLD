import factories.NowOrderFactory;
import factories.OrderFactory;
import factories.ScheduledOrderFactory;
import managers.OrderManager;
import managers.RestaurantManager;
import models.*;
import services.NotificationService;
import strategies.PaymentStrategy;

import java.util.List;

/**
 * ✅ TomatoApp — Main controller/service layer for handling user interactions
 *
 * 💬 Interview Angle:
 * - Acts as a controller in MVC (Model-View-Controller)
 * - Follows SRP: User, Cart, Restaurant, Order management handled modularly
 *
 * ❓ Why?
 * - Code becomes maintainable, testable, and scalable
 */
public class TomatoApp {

    public TomatoApp() {
        initializeRestaurants(); // App boot time initialization
    }

    /**
     * initializeRestaurants - Hardcoded restaurant + menu items setup karta hai
     *
     * ⚠️ Bug Fix:
     * - `restaurant2` ke liye menu mistakenly `restaurant1` me add ho raha tha
     */
    public void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Bikaner", "Jaipur");
        restaurant1.addMenu(new MenuItems("P1", "Samosa", 120));
        restaurant1.addMenu(new MenuItems("P2", "Gulab Jamun", 200));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Bihar");
        restaurant2.addMenu(new MenuItems("12345", "Samosa", 120)); // 🔧 Fix applied
        restaurant2.addMenu(new MenuItems("1298", "Gulab Jamun", 200));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
    }

    /**
     * @param user user who is selecting
     * @param restaurant selected restaurant
     * ❓ Why?
     * - Cart must be locked to a single restaurant
     */
    public void selectRestaurant(User user, Restaurant restaurant) {
        user.getCart().setRestaurant(restaurant);
    }

    /**
     * @param user user whose cart is updated
     * @param itemCode menu item code to add
     * ❓ Why?
     * - Ensures only existing menu items are added from selected restaurant
     */
    public void addToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestaurant();
        if (restaurant == null) {
            System.out.println("❌ Please select a restaurant first.");
            return;
        }

        for (MenuItems item : restaurant.getMenuItems()) {
            if (item.getCode().equals(itemCode)) {
                user.getCart().addItem(item);
                System.out.println("✅ Added to cart: " + item.getName());
                return;
            }
        }

        System.out.println("❌ Item not found in selected restaurant.");
    }

    /**
     * @param location city/location to search restaurants
     * @return List of matching restaurants
     */
    public List<Restaurant> searchRestaurant(String location) {
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    /**
     * @param user current user
     * @param orderType type of order (e.g., Delivery, Dine-in)
     * @param paymentStrategy strategy to use for payment (UPI, Card, etc.)
     * @return Order if checkout is successful
     */
    public Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    /**
     * @param user user placing order
     * @param orderType e.g. Delivery
     * @param paymentStrategy payment method
     * @param scheduledTime time when order should be delivered
     * @return Scheduled Order
     */
    public Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduledTime) {
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduledTime));
    }

    /**
     * Common logic for checkout, used by Now & Scheduled orders
     */
    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if (user.getCart().isEmpty()) {
            System.out.println("❌ Cart is empty. Cannot place order.");
            return null;
        }

        Cart userCart = user.getCart();
        Restaurant orderRestaurant = userCart.getRestaurant();
        List<MenuItems> itemsOrdered = userCart.getMenuItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user, userCart, orderRestaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    /**
     * @param user current user
     * @param order user's order to pay
     *
     * ❓ Why?
     * - Payment + Notification + Cart Clear = All-in-one flow
     */
    public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if (isPaymentSuccess) {
            NotificationService.notify(order);
            user.getCart().clear();
        } else {
            System.out.println("❌ Payment failed. Try again.");
        }
    }

    /**
     * @param user whose cart we want to print
     */
    public void printUserCart(User user) {
        System.out.println("\n🛒 Items in Cart:");
        System.out.println("-------------------------------------");
        for (MenuItems items : user.getCart().getMenuItems()) {
            System.out.println(items.getCode() + " : " + items.getName() + " : ₹" + items.getPrice());
        }
        System.out.println("----------------------------------------");
        System.out.println("💰 Grand Total: ₹" + user.getCart().getTotalCost());
    }
}
