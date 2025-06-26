package models;

/**
 * ✅ User — Zomato app ka end user representation class
 *
 * ⚙️ Working:
 * - User ki basic details store karta hai: userId, name, address.
 * - Har user ke paas ek apna Cart object hota hai jisme wo items add karta hai.
 * - Constructor mein userId, name, address set karte hain aur naya empty Cart initialize hota hai.
 * - Getters aur setters encapsulation ke liye provide kiye gaye hain.
 *
 * 💬 Interview Angle:
 * - User entity model karna real-world app mein common hota hai.
 * - Composition dikhata hai — User ke andar Cart object hai (has-a relationship).
 * - Immutable fields pe bhi dhyan dena chahiye, par yahan simple mutable design rakha hai.
 *
 * ❓ Why?
 * - User ko uniquely identify karne ke liye userId zaruri hai — jaise DB primary key.
 * - Name aur address store karna essential hai delivery aur personalization ke liye.
 * - Cart ko User ke sath link karna zaruri hai taaki har user ka order process smoothly ho.
 * - Cart ko initialize karna constructor mein ye ensure karta hai ki har user ke paas ek ready cart ho, jo use kar sakte hain bina null check ke.
 * - Encapsulation se data safe rehta hai aur future mein validation ya logic add karna easy hota hai.
 */
public class User {
    private int userId;       // Unique user identifier
    private String name;      // User ka naam
    private String address;   // User ka delivery address
    private Cart cart;        // User ka personal cart (composition)

    /**
     * Constructor to initialize User object with required details.
     *
     * @param userId  Unique identifier for user, important for DB and tracking.
     * @param name    User ka naam, personalization ke liye use hota hai.
     * @param address User ka delivery address, orders deliver karne ke liye zaruri.
     */
    public User(int userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.cart = new Cart();   // Har user ke liye ek fresh empty cart banate hain
    }

    // Getters and setters for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cart=" + cart +
                '}';
    }
}
