
class SingletonThread{
    public static SingletonThread thread=null;

    private SingletonThread(){
        System.out.println("Singleton class is thread safe");
    }
    //Thread safe here
    public static synchronized SingletonThread getInstance(){
        if (thread == null){
            thread = new SingletonThread();
        }
        return thread;
    }
}

public class SingletonThreadSafeUsingSynchronizationMethod {
    public static void main(String[] args) {
        SingletonThread instance = SingletonThread.getInstance();
        SingletonThread instance1 = SingletonThread.getInstance();
        System.out.println(instance==instance1);
    }
}
