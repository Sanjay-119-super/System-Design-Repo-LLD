
class SingletonDoubleLocking{
    public static volatile SingletonDoubleLocking singletonDoubleLocking=null;

    private SingletonDoubleLocking(){
        System.out.println("Singleton class thread safe using double locking");
    }

    public static SingletonDoubleLocking getInstance(){
        if (singletonDoubleLocking == null){
            synchronized (SingletonDoubleLocking.class){
                if (singletonDoubleLocking==null){
                    singletonDoubleLocking= new SingletonDoubleLocking();
                }
            }
        }
        return singletonDoubleLocking;
    }
}

public class SingletonMoreEfficientThreadSafeUsingDoubleLocking {
    public static void main(String[] args) {
        SingletonDoubleLocking instance = SingletonDoubleLocking.getInstance();
        SingletonDoubleLocking instance1 = SingletonDoubleLocking.getInstance();
        System.out.println(instance==instance1);
    }
}
