class SingletonBillPugh{
    private SingletonBillPugh(){
        System.out.println("Best Way to making singleton class Thread-Safe");
    }
    private static class SingletonBillPughHelperMethod{
        private static final SingletonBillPugh INSNTANCE = new SingletonBillPugh();
    }
    public static SingletonBillPugh getInstance(){
        return SingletonBillPughHelperMethod.INSNTANCE;
    }
}

public class BestWayToThreadSafeSingletonClass {
    public static void main(String[] args) {
        SingletonBillPugh instance = SingletonBillPugh.getInstance();
        SingletonBillPugh instance1 = SingletonBillPugh.getInstance();
        System.out.println(instance==instance1);
    }
}
