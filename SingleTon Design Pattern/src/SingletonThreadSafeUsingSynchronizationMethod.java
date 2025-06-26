/**
 * SingletonThread class ek thread-safe singleton implementation hai.
 * Yahan getInstance() method ko "synchronized" kiya gaya hai
 * taaki multi-threaded environment mein ek hi instance ban sake.
 */
class SingletonThread {
    // Singleton object store karne ke liye static variable
    private static SingletonThread thread = null;

    // Private constructor taaki bahar se naya object na ban sake
    private SingletonThread() {
        System.out.println("Singleton class is thread safe");
    }

    /**
     * Thread-safe method jo single instance return karta hai.
     * "synchronized" keyword ensure karta hai ki ek time pe
     * sirf ek thread hi is method ko access kare.
     *
     * Note: Synchronized method thoda slow ho sakta hai
     * kyunki har call pe lock lagta hai.
     *
     * @return SingletonThread class ka single instance
     */
    public static synchronized SingletonThread getInstance() {
        if (thread == null) {
            thread = new SingletonThread();
        }
        return thread;
    }
}

/**
 * Test class to check thread-safe Singleton implementation.
 */
public class SingletonThreadSafeUsingSynchronizationMethod {
    public static void main(String[] args) {
        // Do baar getInstance call karke check karte hain
        SingletonThread instance = SingletonThread.getInstance();
        SingletonThread instance1 = SingletonThread.getInstance();

        // Check karte hain dono references same object hain ya nahi
        System.out.println(instance == instance1);  // true aayega
    }
}
