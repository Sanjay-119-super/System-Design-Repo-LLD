package models;

import strategies.PaymentStrategy;

import java.util.List;

/**
 * ✅ DeliveryOrder — Order ka ek subtype jo user ke address par delivery ke liye hota hai
 *
 * ⚙️ Working:
 * - User ka delivery address store karta hai.
 * - getType() method "Delivery" return karta hai to order type identify karne ke liye.
 * - Parent class Order se items, user, restaurant, payment strategy, total etc inherit karta hai.
 *
 * 💬 Interview Angle:
 * - Inheritance aur polymorphism ka practical use.
 * - Real-world mein different order types ke liye specific classes.
 *
 * ❓ Why?
 * - Delivery orders ke liye alag address important hota hai.
 * - System ko easily extendable aur maintainable banata hai.
 */
public class DeliveryOrder extends Order {
    private String userAddress;

    /**
     * Parameterized constructor jo DeliveryOrder ke fields initialize karta hai.
     *
     * @param user          Order place karne wala user
     * @param restaurant    Order wala restaurant
     * @param items         List of MenuItems jo order mein hain
     * @param paymentStrategy Payment method jo use hoga
     * @param total         Total amount of order
     * @param scheduled     Scheduled delivery time (agar hai to)
     * @param userAddress   Delivery ke liye user ka address
     */
    public DeliveryOrder(User user, Restaurant restaurant, List<MenuItems> items,
                         PaymentStrategy paymentStrategy, double total, String scheduled,
                         String userAddress) {
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.paymentStrategy = paymentStrategy;
        this.total = total;
        this.scheduled = scheduled;
        this.userAddress = userAddress;
    }

    /**
     * Default constructor with empty userAddress.
     */
    public DeliveryOrder() {
        this.userAddress = " ";
    }

    /**
     * getType - Order ka type return karta hai
     *
     * ⚙️ Working:
     * - DeliveryOrder me fixed "Delivery" type return hota hai
     *
     * 💬 Interview Angle:
     * - Polymorphism ka use karke alag-alag order types distinguish karte hain
     *
     * ❓ Why?
     * - Order processing me delivery aur dine-in ya takeaway orders ko alag handle karna hota hai
     * - Isliye har subclass apna specific type return karta hai
     *
     * @return String - order type
     */
    @Override
    public String getType() {
        return "Delivery";
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * toString - DeliveryOrder ke details string me return karta hai
     *
     * ⚙️ Working:
     * - DeliveryOrder ke saare important fields ko readable format me return karta hai
     *
     * 💬 Interview Angle:
     * - Debugging aur logging me useful hota hai
     *
     * ❓ Why?
     * - Delivery address aur order details order tracking ke liye important hote hain
     * - ToString method se ise easily print ya log kar sakte hain
     *
     * @return String - DeliveryOrder ki details string format me
     */
    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", restaurant=" + restaurant +
                ", items=" + items +
                ", paymentStrategy=" + paymentStrategy +
                ", total=" + total +
                ", scheduled='" + scheduled + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
