package managers;

import models.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * ✅ OrderManager — Real-World Order Management System using Singleton Pattern
 *
 * 🔥 Real-World Role:
 * Zomato jaise system mein har order ko track karne ke liye ek centralized class chahiye hoti hai
 * jo saare placed orders ko store kare aur unhe retrieve/list kare.
 *
 * ⚙️ Working:
 * - Ye class orders ko ek list mein store karti hai.
 * - Singleton design pattern use kiya gaya hai taaki system mein sirf ek hi instance ho.
 * - Har baar jab koi user order karega, woh `addOrder()` method ke through store hoga.
 * - Admin ya developer `listOrder()` ke through sabhi orders dekh sakta hai.
 *
 * 💬 Interview Angle:
 * - Singleton ensures consistency across system.
 * - Yeh thread-safe nahi hai (abhi basic version hai).
 * - Future mein isme DB, logging, thread-safety add kiya ja sakta hai.
 */
public class OrderManager {

    // ✅ Step 1: Internal data structure for storing orders
    // Thought: Memory mein temporarily sab orders ko hold karega
    // ❓ Why?
    // Kyunki har baar DB hit karna costly hota hai, aur quick retrieval ke liye memory mein rakhna fast hota hai.
    // Testing aur prototyping mein bhi ye convenient hota hai.
    private List<Order> orders = new ArrayList<>();


    // 🔒 Step 2: Singleton Instance
    // Thought: Sirf ek hi instance pure application mein ho — consistency ke liye
    // ❓ Why?
    // Multiple instances banne se order data scattered ho jayega, jo data inconsistency aur bugs la sakta hai.
    // Singleton pattern ensure karta hai ki ek hi centralized data source rahe.
    private static OrderManager instance = null;


    // 🚫 Step 3: Private Constructor
    // Thought: External code se direct new object create karne se roka jaata hai
    // ❓ Why?
    // Isse object creation control mein rahta hai, aur sirf getInstance() se hi instance milta hai.
    // Ye design pattern ka fundamental rule hai taaki Singleton achieve ho sake.
    private OrderManager() {
        // Real project mein yahan logging ya metrics bhi initialize ho sakte hain
    }


    /**
     * 🔁 Step 4: getInstance() — Singleton ka public access point
     *
     * 🔍 Internal Thought:
     * - Pehli baar jab yeh method call hota hai, tab instance banaya jaata hai (lazy initialization).
     * - Har baar wahi instance return hota hai — system ke har component ko centralized access deta hai.
     *
     * 💡 Interview Tip:
     * - Yeh thread-safe nahi hai. Real-world multithreading mein `synchronized` block ya double-check locking ka use hota hai.
     *
     * ❓ Why?
     * Centralized instance chahiye taaki application ke har part mein ek hi order data consistency bana rahe.
     * Lazy initialization se resource tabhi use hota hai jab zarurat hoti hai, unnecessary memory bachti hai.
     */
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }


    /**
     * ✅ Step 5: addOrder — Naya order add karta hai system ke andar
     *
     * @param order - order object jo add karna hai
     *
     * 🔧 Working:
     * - Jab user Zomato pe "Place Order" karta hai, woh backend mein is method se store hota hai.
     * - Yeh order later use hota hai delivery, admin panel, analytics, aur notifications ke liye.
     *
     * 🔍 Thought Process:
     * - Direct DB store bhi ho sakta tha, but memory mein rakhna fast access aur testing ke liye useful hai.
     *
     * ❓ Why?
     * Quick access ke liye, jaise ki order status update, cancel karna ya admin review.
     * Future mein easily DB integration kar sakte hain, abhi simple rakhne ke liye memory mein rakh rahe hain.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }


    /**
     * ✅ Step 6: listOrder — Sabhi placed orders ko console pe print karta hai
     *
     * 🔧 Working:
     * - Har order ke type, user, price aur scheduled time ko dikhata hai.
     * - Zomato jaise admin dashboard mein is data ko tabular form mein frontend show karta hai — yahan console mein.
     *
     * 🧠 Internal Soch:
     * - Developer ya tester ke liye debug mein helpful.
     * - Later isko file, UI ya REST API ke through bhi expose kiya ja sakta hai.
     *
     * ❓ Why?
     * Orders ko track karna bahut zaroori hai system ke health ke liye, aur bugs find karne ke liye.
     * User feedback ya delivery coordination mein bhi ye data important hota hai.
     */
    public void listOrder() {
        System.out.println("\n--- All Orders ----");

        // 🔁 Loop through all stored orders and print details
        for (Order order : orders) {
            System.out.println(
                    order.getType() + " order for " + order.getUser().getName()
                            + " | Total Price : ₹" + order.getTotal()
                            + " | Scheduled At: " + order.getScheduled()
            );
        }
    }
}
