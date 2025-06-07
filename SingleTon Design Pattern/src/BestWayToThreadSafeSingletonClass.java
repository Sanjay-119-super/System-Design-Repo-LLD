/**
 * SingletonBillPugh class me Bill Pugh Singleton Design Pattern use kiya gaya hai,
 * jo sabse best aur efficient tarika hai thread-safe singleton banane ka.
 *
 * Is pattern me static inner helper class ka use hota hai.
 * JVM ke class loading mechanism se thread safety automatic mil jati hai,
 * bina synchronized blocks ya volatile variables ke.
 *
 * Helper class tabhi load hoti hai jab getInstance() call hota hai,
 * isliye ye lazy initialization bhi provide karta hai.
 */
class SingletonBillPugh {
    // Private constructor to prevent instantiation from other classes
    private SingletonBillPugh() {
        System.out.println("Best Way to making singleton class Thread-Safe");
    }

    // Static inner helper class, jo instance ko hold karta hai
    private static class SingletonBillPughHelperMethod {
        // Final instance create hota hai jab helper class load hoti hai
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    /**
     * Public method jo instance return karta hai.
     * Jab ye method pehli baar call hota hai,
     * tabhi inner helper class load hoti hai aur instance create hota hai.
     *
     * Ye thread-safe bhi hai aur lazy initialization bhi provide karta hai.
     *
     * @return SingletonBillPugh ka unique instance
     */
    public static SingletonBillPugh getInstance() {
        return SingletonBillPughHelperMethod.INSTANCE;
    }
}

public class BestWayToThreadSafeSingletonClass {
    public static void main(String[] args) {
        SingletonBillPugh instance = SingletonBillPugh.getInstance();
        SingletonBillPugh instance1 = SingletonBillPugh.getInstance();

        // Dono references same instance ko point karenge, output true hoga
        System.out.println(instance == instance1);
    }
}
