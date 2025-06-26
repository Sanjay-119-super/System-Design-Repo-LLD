package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItems> menuItems = new ArrayList<>();

    public Cart(){
        restaurant = null;
    }

    /**
     * addItem - Cart me ek menu item add karta hai
     *
     * ⚙️ Working:
     * - Pehle check karta hai ki restaurant set hai ya nahi
     * - Agar restaurant null hai to item add nahi karta
     * - Agar restaurant set hai to item list me add kar deta hai
     *
     * 💬 Interview Angle:
     * - Cart me ek hi restaurant ke items hone chahiye
     * - Multiple restaurant ke items cart me mix nahi hone chahiye
     *
     * ❓ Why?
     * - Multiple restaurants ke items ek cart me hone se order process karna complex ho jata hai
     * - Delivery, billing aur tracking me problem hoti hai
     * - Isliye consistency ke liye restaurant set hona zaroori hai
     *
     * @param items MenuItems object jo cart me add karna hai
     */
    public void addItem(MenuItems items){
        if (restaurant == null){
            System.err.println("Cart: Set a restaurant before adding.");
            return;
        }
        menuItems.add(items);
    }

    /**
     * getTotalCost - Cart ke sare items ka total price calculate karta hai
     *
     * ⚙️ Working:
     * - MenuItems list ko iterate karta hai
     * - Har item ki price ko sum karta hai
     * - Total price return karta hai
     *
     * 💬 Interview Angle:
     * - Checkout ke time total cost calculate karna zaroori hota hai
     * - Simple iteration based solution hai
     *
     * ❓ Why?
     * - Total cost user ko batana hai checkout ke liye
     * - Ye method saare items ka price sum kar ke quick calculation deta hai
     *
     * @return double Cart ke sare items ka total price
     */
    public double getTotalCost(){
        double sum = 0;
        for (MenuItems cost : menuItems){
            sum += cost.getPrice();
        }
        return sum;
    }

    /**
     * isEmpty - Check karta hai cart khali hai ya nahi
     *
     * ⚙️ Working:
     * - Restaurant null hai ya menuItems list empty hai to cart empty hai
     *
     * 💬 Interview Angle:
     * - Checkout button disable karne me madad karta hai agar cart empty ho
     *
     * ❓ Why?
     * - Cart empty hone par order place nahi kar sakte
     * - Isliye ye check karna zaroori hai ki cart me items hain ya nahi
     *
     * @return boolean true agar cart empty hai, false otherwise
     */
    public boolean isEmpty(){
        return restaurant == null || menuItems.isEmpty();
    }

    /**
     * clear - Cart ko reset karta hai
     *
     * ⚙️ Working:
     * - MenuItems list clear karta hai
     * - Restaurant ko null set karta hai
     *
     * 💬 Interview Angle:
     * - Order place hone ya cancel hone par cart reset karna hota hai
     *
     * ❓ Why?
     * - Naya order start karne ke liye clean state chahiye
     * - Purana data mix na ho jaye isliye cart clear karte hain
     */
    public void clear(){
        menuItems.clear();
        restaurant = null;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * setRestaurant - Cart me restaurant set karta hai
     *
     * @param restaurant Restaurant object jise cart ke liye set karna hai
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    /**
     * setMenuItems - Cart ke menu items ko set karta hai
     *
     * @param menuItems MenuItems ki list jo cart me set karni hai
     */
    public void setMenuItems(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * toString - Cart ke content ko string form me return karta hai
     *
     * ⚙️ Working:
     * - Restaurant aur menuItems ko string format me return karta hai
     *
     * 💬 Interview Angle:
     * - Debugging aur logging ke liye useful hota hai
     *
     * ❓ Why?
     * - Data ko easily readable form me dekhna hota hai jab debug karte hain
     * - Logging ke liye bhi ye helpful hota hai
     *
     * @return String Cart ke current content ka readable string representation
     */
    @Override
    public String toString() {
        return "Cart{" +
                "restaurant=" + restaurant +
                ", menuItems=" + menuItems +
                '}';
    }
}
