

class SingletonEagerInitialization{
    private static final SingletonEagerInitialization singleton = new SingletonEagerInitialization();

    private SingletonEagerInitialization(){
        System.out.println("Singleton class is create with Thread safe without using syncronization");
    }
    public static SingletonEagerInitialization getInstance(){
        return singleton;
    }
}

public class SingletonUsingEagerLoading {
    public static void main(String[] args) {
        SingletonEagerInitialization instance = SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization instance1 = SingletonEagerInitialization.getInstance();
        System.out.println(instance==instance1);

    }
}
