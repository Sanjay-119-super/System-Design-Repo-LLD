package managers;

import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * ✅ RestaurantManager — Singleton Class to Manage Restaurants Data
 *
 * 🎯 Real World Role:
 * - Zomato jaise app mein kai saare restaurants hote hain.
 * - User jab apne location ke hisaab se restaurants dhundta hai,
 *   toh centralized manager unko search karke deta hai.
 *
 * ⚙️ Working:
 * - Ye class restaurants ki list ko manage karti hai (add, search).
 * - Singleton use kiya gaya taaki ek hi instance se sab manage ho.
 * - Search function case-insensitive location match karta hai.
 *
 * 💡 Interview Tip:
 * - Thread-safe nahi hai ye singleton.
 * - Search ke liye efficient data structure jaise Map bhi use kar sakte hain.
 * - Simple and clean design for POC or small app.
 */
public class RestaurantManager {

    // ✅ Step 1: Internal data structure to hold all restaurants
    private List<Restaurant> restaurants = new ArrayList<>();

    // 🔒 Step 2: Singleton instance for global access
    private static RestaurantManager instance = null;

    // 🚫 Step 3: Private constructor to prevent external instantiation
    private RestaurantManager() {
        // Future enhancement: Load initial data, connect to DB, etc.
    }

    /**
     * 🔁 Step 4: Singleton getInstance method
     *
     * 🧠 Internal Thought:
     * - Lazy initialization: Pehli baar jab call ho tabhi object banega.
     * - Ensures single source of truth across application.
     * - Not thread-safe — multithreading ke liye synchronized banana padega.
     */
    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    /**
     * ✅ Step 5: Add new restaurant to the list
     *
     * 🛠 Working:
     * - Jab admin ya system koi naya restaurant add karta hai, to ye method call hota hai.
     * - Restaurant object list mein daal diya jata hai.
     */
    public void addRestaurant(Restaurant res) {
        restaurants.add(res);
    }

    /**
     * ✅ Step 6: Search restaurants by location (case-insensitive)
     *
     * @param loc - user input location string
     * @return list of restaurants matching exact location
     *
     * 🧠 Internal Logic:
     * - User ne koi location di, jise lower-case mein convert kiya taaki
     *   search case-insensitive ho jaye.
     * - Restaurants ke location fields bhi lower-case mein compare kiye.
     * - Jo exact match karta hai, use result list mein add kiya.
     *
     * ⚠️ Limitations:
     * - Exact match pe hi kaam karta hai (partial match ya fuzzy search nahi).
     * - Large dataset ke liye efficient search data structures (hash map, trie) chahiye.
     */
    public List<Restaurant> searchByLocation(String loc) {
        List<Restaurant> result = new ArrayList<>();
        loc = loc.toLowerCase();

        for (Restaurant restaurant : restaurants) {
            String r1 = restaurant.getLocation().toLowerCase();

            if (r1.equals(loc)) {
                result.add(restaurant);
            }
        }
        return result;
    }
}
