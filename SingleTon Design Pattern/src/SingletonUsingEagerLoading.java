/**
 * SingletonEagerInitialization class me eager loading se singleton banaya gaya hai.
 *
 * Isme instance class load hone ke time hi create ho jata hai, isliye ye thread-safe hai
 * bina kisi synchronization ke.
 *
 * Lekin agar object heavy ho ya jarurat na ho turant, toh ye thoda resource waste kar sakta hai.
 *
 * Use-case:
 * Jab hum sure hain ki singleton instance hamesha chahiye aur jaldi chahiye.
 */
class SingletonEagerInitialization {
    // Static final instance: class load hote hi create ho jayega
    private static final SingletonEagerInitialization singleton = new SingletonEagerInitialization();

    // Private constructor: bahar se object create nahi kar sakte
    private SingletonEagerInitialization() {
        System.out.println("Singleton class is created with Thread safe without using synchronization");
    }

    /**
     * Static method jo hamesha wahi pre-created instance return karta hai.
     *
     * Isme synchronization ki zarurat nahi kyunki instance pehle se hi ready hai.
     *
     * @return SingletonEagerInitialization ka single instance
     */
    public static SingletonEagerInitialization getInstance() {
        return singleton;
    }
}

/**
 * Testing class to check Singleton using eager loading.
 */
public class SingletonUsingEagerLoading {
    public static void main(String[] args) {
        SingletonEagerInitialization instance = SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization instance1 = SingletonEagerInitialization.getInstance();

        // Dono references same object point karte hain, isliye true print hoga
        System.out.println(instance == instance1);
    }
}
