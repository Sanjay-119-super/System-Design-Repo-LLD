public class Singleton {
    public static Singleton singleton=null;

    private Singleton(){
        System.out.println("Singleton Pattern");
    }

    public static Singleton getInstance(){
        if (singleton==null){
             singleton = new Singleton();
        }
        return singleton;
    }
}

class Check{
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance==instance1);


    }
}
