/**
 * SingletonDoubleLocking class mein thread-safe singleton implementation hai
 * using Double-Checked Locking technique.
 *
 * Volatile keyword ensure karta hai ki instance ki visibility
 * sabhi threads ko turant mile.
 */
class SingletonDoubleLocking {
    // Volatile variable taaki multiple threads ko updated value dikhe
    private static volatile SingletonDoubleLocking singletonDoubleLocking = null;

    // Private constructor taaki bahar se naya object na ban sake
    private SingletonDoubleLocking() {
        System.out.println("Singleton class thread safe using double locking");
    }

    /**
     * Double-checked locking wala thread-safe getInstance method.
     * Pehle bina lock ke check karta hai agar instance null hai,
     * fir synchronized block mein dobara check karke instance banata hai.
     *
     * Isse performance better hoti hai kyunki lock sirf pehli baar
     * instance create hone par lagta hai.
     *
     * @return SingletonDoubleLocking ka single instance
     */
    public static SingletonDoubleLocking getInstance() {
        if (singletonDoubleLocking == null) {                 // First check (without locking)
            synchronized (SingletonDoubleLocking.class) {    // Lock lagaya
                if (singletonDoubleLocking == null) {         // Second check (with locking)
                    singletonDoubleLocking = new SingletonDoubleLocking();
                }
            }
        }
        return singletonDoubleLocking;
    }
}

/**
 * Test class to check Double-Checked Locking based Singleton implementation.
 */
public class SingletonMoreEfficientThreadSafeUsingDoubleLocking {
    public static void main(String[] args) {
        SingletonDoubleLocking instance = SingletonDoubleLocking.getInstance();
        SingletonDoubleLocking instance1 = SingletonDoubleLocking.getInstance();

        // Check karte hain dono references same object hain ya nahi
        System.out.println(instance == instance1);  // true aayega
    }
}
