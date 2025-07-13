package enums;

/**
 * DeviceType enum define karta hai ki user kaunsa audio output device use kar raha hai.
 *
 * Ye enum help karta hai system ko yeh samajhne me ki kis adapter ko use karna hai
 * jab audio output ka time aaye (e.g., Bluetooth, Wired speaker, Headphone, etc.)
 */
public enum DeviceType {

    /**
     * Bluetooth-enabled speaker ya output device.
     * Ye mostly wireless external speakers hote hain.
     */
    BLUETOOTH,

    /**
     * Wired speaker jo generally cable ke through connected hota hai (like AUX cable).
     */
    WIRED,

    /**
     * Headphones jo mobile, laptop ya speaker jack se connected hote hain.
     */
    HEADPHONE;
}
