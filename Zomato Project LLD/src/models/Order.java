package models;

import strategies.PaymentStrategy;

import java.util.List;

/**
 * ✅ Order — Abstract class jo generic order properties aur behaviour define karti hai
 *
 * ⚙️ Working:
 * - Har order ka unique orderId hota hai jo static counter se auto-increment hota hai.
 * - User, Restaurant, Items, PaymentStrategy, total price, aur scheduled time store karta hai.
 * - processPayment() method payment strategy ke hisaab se payment complete karta hai.
 *
 * 💬 Interview Angle:
 * - Abstract class aur inheritance ka example jahan different order types extend kar sakte hain.
 * - Strategy design pattern payment ke liye use hua hai.
 * - Encapsulation with getters/setters.
 * - Static variable se unique orderId generate karna.
 *
 * ❓ Why?
 * - Different order types (delivery, pickup) ke liye ek common base class banani chahiye.
 * - Payment logic flexible rakhna chahiye taaki naye payment modes easily add kar sake.
 * - Order ke common data aur methods centralized ho jaye.
 */
public abstract class Order {
    private static int nextOrder = 0;  // Unique orderId generate karne ke liye static counter
    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItems> items;
    protected PaymentStrategy paymentStrategy;
    protected double total;
    protected String scheduled;

    /**
     * Default constructor jo orderId ko auto-increment karta hai aur baaki fields ko default initialize karta hai.
     */
    public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderId = ++nextOrder;
    }

    /**
     * ✅ processPayment — Payment strategy ke through payment process karta hai
     *
     * ⚙️ Working:
     * - Agar paymentStrategy set hai, to paymentStrategy.pay(total) call hota hai
     * - Payment complete hone ke baad true return karta hai
     * - Agar payment strategy set nahi hai, to user ko prompt karta hai pehle payment mode choose karne ke liye
     *
     * 💬 Interview Angle:
     * - Strategy design pattern ka example hai jahan payment method dynamically change ho sakta hai
     * - Loose coupling aur open-closed principle follow hota hai
     *
     * ❓ Why?
     * - Payment methods alag-alag ho sakte hain (Credit Card, UPI, Wallet, COD), isliye abstraction important hai
     * - Hardcoded payment logic maintain karna mushkil hota, isliye strategy pattern se flexibility aur extendability milti hai
     * - Payment process ko reusable aur testable banana zaruri hai production code mein
     *
     * @return boolean - true agar payment successful hua, warna false
     */
    public boolean processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.pay(this.total);
            return true;
        } else {
            System.out.println("Please choose payment mode first.");
            return false;
        }
    }

    /**
     * Abstract method jo order type return karta hai (delivery, pickup, etc).
     *
     * @return String - order type
     */
    public abstract String getType();

    /**
     * Static getter for nextOrder static counter.
     *
     * @return int - next available orderId
     */
    public static int getNextOrder() {
        return nextOrder;
    }

    /**
     * Static setter for nextOrder static counter.
     *
     * @param nextOrder - new value set karna nextOrder ke liye
     */
    public static void setNextOrder(int nextOrder) {
        Order.nextOrder = nextOrder;
    }

    /**
     * Order ka unique ID getter.
     *
     * @return int - orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Order ID setter.
     *
     * @param orderId - set karna order ka unique ID
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * User getter jo order place karta hai.
     *
     * @return User - order karne wala user
     */
    public User getUser() {
        return user;
    }

    /**
     * User setter.
     *
     * @param user - order karne wala user set karna
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Restaurant getter jahan se order liya gaya hai.
     *
     * @return Restaurant - restaurant details
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Restaurant setter.
     *
     * @param restaurant - restaurant set karna order ke liye
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Order mein items ka list getter.
     *
     * @return List<MenuItems> - order ke items
     */
    public List<MenuItems> getItems() {
        return items;
    }

    /**
     * Order items setter.
     *
     * @param items - order mein add karne wale menu items ka list
     */
    public void setItems(List<MenuItems> items) {
        this.items = items;
    }

    /**
     * PaymentStrategy getter jo payment method define karta hai.
     *
     * @return PaymentStrategy - payment ka strategy object
     */
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    /**
     * PaymentStrategy setter.
     *
     * @param paymentStrategy - payment ke liye strategy set karna (CreditCard, UPI, etc)
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Total order amount getter.
     *
     * @return double - order ka total price
     */
    public double getTotal() {
        return this.total;
    }

    /**
     * Total amount setter.
     *
     * @param total - order ka total price set karna
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Scheduled time getter.
     *
     * @return String - order ka scheduled delivery/pickup time
     */
    public String getScheduled() {
        return scheduled;
    }

    /**
     * Scheduled time setter.
     *
     * @param scheduled - delivery ya pickup ka scheduled time set karna
     */
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * Object ka string representation for debugging.
     *
     * @return String - order details string mein
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", restaurant=" + restaurant +
                ", items=" + items +
                ", paymentStrategy=" + paymentStrategy +
                ", total=" + total +
                ", scheduled='" + scheduled + '\'' +
                '}';
    }
}
