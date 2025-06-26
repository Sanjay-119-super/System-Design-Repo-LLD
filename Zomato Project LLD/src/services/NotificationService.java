package services;

import models.MenuItems;
import models.Order;

import java.util.List;

public class NotificationService {
    /**
     * notify - Given Order ke details console pe notification ke roop me print karta hai
     *
     * ⚙️ Working:
     * - Order ka type, ID, customer, restaurant aur items ko print karta hai
     * - Har item ka naam aur price print hota hai
     * - Total price aur scheduled time bhi show karta hai
     *
     * 💬 Interview Angle:
     * - Notification system me user ko order confirmation dikhane ke liye
     * - Real-world apps me ye alert ya push notification ka basic example hai
     *
     * ❓ Why?
     * - Order confirmation user ko inform karna hota hai
     * - Logging aur debugging ke liye bhi useful hota hai
     *
     * @param order Order object jiska notification print karna hai
     */
    public static void notify(Order order){
        System.out.println("\nNotification: New " + order.getType() + " order placed");
        System.out.println("----------------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getUser().getName());
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Items Ordered:");

        List<MenuItems> items = order.getItems();
        for (MenuItems item : items){
            System.out.println("  - " + item.getName() + " (price: " + item.getPrice() + ")");
        }

        System.out.println("Total Price: " + order.getTotal());
        System.out.println("Scheduled for: " + order.getScheduled());
        System.out.println("Payment Done:");
        System.out.println("-------------------------------------------");
    }
}
