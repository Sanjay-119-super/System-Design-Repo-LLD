package models;

/**
 * ✅ PickUpOrder — Order ka ek subtype jo restaurant se direct pick up karne wale orders represent karta hai
 *
 * ⚙️ Working:
 * - Is class mein restaurantAddress store hota hai, jahan se user apna order pick karega.
 * - getType() method override kiya gaya hai to return "Pickup", taaki order ka type clearly identify ho sake.
 * - Baaki properties aur methods Order se inherit hote hain.
 *
 * 💬 Interview Angle:
 * - Yeh inheritance aur polymorphism ka example hai, jisme abstract Order class ko extend karke specific order types banaye gaye hain.
 * - Clean separation of concerns dikhata hai, jisse system easily extendable aur maintainable banta hai.
 *
 * ❓ Why?
 * - Zomato jaisi apps mein delivery aur pick-up dono order types hote hain, dono ka alag handling hota hai, isliye specific class banana zaruri hai.
 * - PickUpOrder ke paas alag address hota hai jo restaurant ka hota hai, user ke address se different — isko clear rakhna maintainability aur clarity ke liye zaruri hai.
 * - Polymorphism se code flexible banta hai, jaise ki order processing mein alag type ke orders ko uniform interface se handle kar sakte hain.
 */
public class PickUpOrder extends Order {

    private String restaurantAddress;

    /**
     * Default constructor jo restaurantAddress ko empty string se initialize karta hai.
     */
    public PickUpOrder() {
        this.restaurantAddress = "";
    }

    /**
     * Order type return karta hai.
     * @return String - "Pickup" string jo order type batata hai
     */
    @Override
    public String getType() {
        return "Pickup";
    }

    /**
     * Restaurant ka address jahan se order pick hoga.
     * @return String - restaurant ka address
     */
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    /**
     * Restaurant address set karta hai.
     * @param restaurantAddress - restaurant ka address jahan se order pick hoga
     */
    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    /**
     * Object ka string representation deta hai jo debugging mein helpful hota hai.
     * @return String - object details string format mein
     */
    @Override
    public String toString() {
        return "PickUpOrder{" +
                "restaurantAddress='" + restaurantAddress + '\'' +
                ", orderId=" + orderId +
                ", user=" + user +
                ", restaurant=" + restaurant +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
