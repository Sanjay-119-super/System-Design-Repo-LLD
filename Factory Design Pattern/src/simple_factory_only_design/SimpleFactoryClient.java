package simple_factory_only_design;

interface Burger{
    void prepare();
}
//class-1
class BasicBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Basic Burger");
    }

    @Override
    public String toString() {
        return "BasicBurger{}";
    }
}

//class-2
class StanderBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Stander Burger");
    }

    @Override
    public String toString() {
        return "StanderBurger{}";
    }
}
//class-2
class PremiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Premium Burger");
    }

}

// todo factor for create product means object
class BurgerFactory{
    public Burger createBurger(String type){
        if (type.equals("basic")){
            return new BasicBurger();
        } else if (type.equals("stander")) {
            return new StanderBurger();
        }
        else {
            return new PremiumBurger();
        }
    }

}
public class SimpleFactoryClient {
    public static void main(String[] args) {
        String type="basic";
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger(type);
        burger.prepare();
        System.out.println("Burger is ready: " + burger);
    }


}
