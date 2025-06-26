package models;

import java.util.ArrayList;
import java.util.List;

/**
 * ✅ Restaurant — Zomato system ka core entity jo restaurant ki details hold karta hai
 *
 * ⚙️ Working:
 * - Har restaurant ka unique ID hota hai jo auto-increment hota hai (nextRestaurantId static se).
 * - Restaurant ke naam, location aur uska menu (list of MenuItems) store karta hai.
 * - addMenu() method se naye menu items add kiye jaate hain.
 * - getMenuItems() se pura menu list retrieve hota hai.
 *
 * 💬 Interview Angle:
 * - Yeh class entity modeling dikhata hai — real-world object ko code mein kaise represent karte hain.
 * - Encapsulation ka use kiya gaya hai private fields ke saath aur getters/setters provide karke.
 * - Static variable se unique ID generation ka simple implementation dikhata hai.
 *
 * ❓ Why?
 * - Zomato jaise apps mein restaurant ki unique identity aur uske menu ka data hona bahut zaruri hai, taaki orders sahi jagah track ho.
 * - MenuItems ko list mein rakhna easy access aur updates ke liye helpful hai.
 * - Static ID generator se har restaurant ko unique ID milta hai jo DB primary key jaisa kaam karta hai.
 * - Location store karne se nearby restaurant search ya delivery zone management aasaan ho jata hai.
 * - Ye design future mein extend karne mein easy hoga — jaise ratings, reviews, open/close timing add karna.
 */
public class Restaurant {
    private static int nextRestaurantId = 0;  // Unique restaurant IDs generate karne ke liye static counter
    private int restaurantId;                  // Har restaurant ka unique ID
    private String name;                       // Restaurant ka naam
    private String order;                      // Yeh field unused lag raha hai, future mein use ho sakta hai
    private String location;                   // Restaurant ka location/address
    private List<MenuItems> menuItems = new ArrayList<>(); // Restaurant ke menu items

    /**
     * Constructor — naye restaurant object ko initialize karta hai naam aur location ke saath
     *
     * @param name     Restaurant ka naam, important for display and identification
     * @param location Restaurant ka location, delivery zone and search ke liye zaruri
     */
    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.restaurantId = ++nextRestaurantId;  // Auto-increment unique ID assign karna
    }

    // Getters and Setters for encapsulation

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * ✅ addMenu — naye menu item ko restaurant ke menu list mein add karta hai
     *
     * ⚙️ Working:
     * - Jab bhi restaurant ka menu update karna ho, is method se item add karte hain.
     *
     * 💬 Interview Angle:
     * - Simple collection manipulation example — list mein data add karna.
     *
     * @param items Naya menu item jo add karna hai
     */
    public void addMenu(MenuItems items) {
        menuItems.add(items);
    }

    /**
     * ✅ getMenuItems — restaurant ka poora menu return karta hai
     *
     * ⚙️ Working:
     * - Menu items ki list ko access karne ke liye getter provide karta hai.
     *
     * 💬 Interview Angle:
     * - Encapsulation ke saath data access ka example.
     *
     * @return List<MenuItems> — restaurant ke sabhi menu items
     */
    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", location='" + location + '\'' +
                ", menuItems=" + menuItems +
                '}';
    }
}
