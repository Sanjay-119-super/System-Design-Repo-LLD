package models;

/**
 * ✅ MenuItems — Restaurant ke menu mein ek item ko represent karta hai
 *
 * ⚙️ Working:
 * - Har item ka unique code, naam, aur price hota hai.
 * - Getter aur setter methods ke through encapsulation maintain karta hai.
 *
 * 💬 Interview Angle:
 * - Simple POJO (Plain Old Java Object) jo data ko hold karta hai.
 * - toString method debugging aur logs ke liye useful hai.
 *
 * ❓ Why?
 * - Real-world apps mein menu items ki details ko structured way mein represent karna important hota hai.
 * - Encapsulation se data security aur maintainability milti hai.
 */
public class MenuItems {
    private String code;
    private String name;
    private double price;

    /**
     * Parameterized constructor jo MenuItem ka code, name, aur price set karta hai.
     *
     * @param code  Unique identifier for the menu item
     * @param name  Name of the menu item
     * @param price Price of the menu item
     */
    public MenuItems(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    /**
     * Menu item ka unique code getter.
     *
     * @return String - menu item ka code
     */
    public String getCode() {
        return code;
    }

    /**
     * Menu item ka code setter.
     *
     * @param code - menu item ke liye unique code set karta hai
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Menu item ka naam getter.
     *
     * @return String - menu item ka naam
     */
    public String getName() {
        return name;
    }

    /**
     * Menu item ka naam setter.
     *
     * @param name - menu item ka naam set karta hai
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Menu item ka price getter.
     *
     * @return double - menu item ka price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Menu item ka price setter.
     *
     * @param price - menu item ka price set karta hai
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * ✅ toString — MenuItem ke details ko readable string format me convert karta hai
     *
     * ⚙️ Working:
     * - Item ke code, name, aur price ko ek formatted string me return karta hai
     *
     * 💬 Interview Angle:
     * - Debugging ke liye helpful hota hai
     * - Logs me data easily samajhne ke liye important hai
     *
     * ❓ Why?
     * - Real-world projects me jab objects ko print karna hota hai to unka meaningful representation chahiye hota hai
     * - Manual string banane se code repetitive hota hai, isliye toString override karke simple access milta hai
     * - Ye method debugging, monitoring aur logs ke liye fast aur readable information provide karta hai
     *
     * @return String - menu item ki details ek readable string mein
     */
    @Override
    public String toString() {
        return "MenuItems{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
