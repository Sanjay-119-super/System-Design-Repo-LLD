/**
 * Singleton class ka matlab hota hai ki is class ka sirf ek hi object
 * pure program mein create hoga.
 * Yeh version "lazy initialization" use karta hai,
 * matlab instance tab banta hai jab pehli baar call kiya jata hai.
 */
public class Singleton {

    // Static variable jisme single instance store hoga
    private static Singleton singleton = null;

    // Private constructor taaki koi bahar se naya object na bana sake
    private Singleton() {
        System.out.println("Singleton Pattern");
    }

    /**
     * Ye method sabko ek hi instance provide karega.
     * Agar abhi tak instance nahi bana hai, toh banayega.
     * Warning: Ye thread-safe nahi hai,
     * matlab multi-thread environment mein dikkat ho sakti hai.
     *
     * @return Singleton class ka single object
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

/**
 * Ye test class hai jo Singleton pattern ko check karta hai.
 */
class Check {
    public static void main(String[] args) {
        // Do baar getInstance call kar rahe hain
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        // Dono reference same object ko point karte hain ya nahi, print karega true
        System.out.println(instance == instance1);
    }
}
