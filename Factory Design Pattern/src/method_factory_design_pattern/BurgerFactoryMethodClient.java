package method_factory_design_pattern;

import jdk.nashorn.internal.ir.SplitReturn;

interface Burger{
    void prepare();
}

// BASIC----
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

class StandardBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Standard Burger");
    }

    @Override
    public String toString() {
        return "StandardBurger{}";
    }
}

class PremiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Premium Burger");
    }

    @Override
    public String toString() {
        return "PremiumBurger{}";
    }
}

//BASIC & WHEAT
class BasicWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Basic Wheat Burger");
    }

    @Override
    public String toString() {
        return "BasicWheatBurger{}";
    }
}

class StandardWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Standard Wheat Burger");
    }

    @Override
    public String toString() {
        return "StandardWheatBurger{}";
    }
}

class PremiumWheatBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Premium Wheat Burger");
    }

    @Override
    public String toString() {
        return "PremiumWheatBurger{}";
    }
}

// Burger Factory
interface BurgerFactory{
    Burger createBurger(String type);
}

class SighBurger implements BurgerFactory{
    @Override
    public Burger  createBurger(String type) {
        if (type.equals("basic"))
            return new  BasicBurger();
        else if (type.equals("standard"))
            return new StandardBurger();
        else
            return new PremiumBurger();
    }
}

class KingBurger implements BurgerFactory{
    @Override
    public Burger createBurger(String type) {
        if (type.equals("basicWheat"))
            return new BasicWheatBurger();
        else if (type.equals("standardWheat"))
            return new StandardWheatBurger();
        else
            return new PremiumWheatBurger();
    }
}
public class BurgerFactoryMethodClient {
    public static void main(String[] args) {
        String singh = "basic";
        BurgerFactory burgerFactory = new SighBurger();
        Burger burger = burgerFactory.createBurger(singh);
        burger.prepare();
        System.out.println("Burger is ready : " + burger);

        System.out.println("-------------------");

        String king = "basicWheat";
        BurgerFactory burgerFactory1 = new KingBurger();
        Burger burger1 = burgerFactory1.createBurger(king);
        burger1.prepare();
        System.out.println("Burger is done: " + burger1);


    }
}
