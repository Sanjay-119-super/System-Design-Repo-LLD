package abstarct_factory_method;

public class ClientAbstractMethod {
    public static void main(String[] args) {
        // Choose factory (SinghBurger or KingBurger)
        Factory factory = new KingBurger(); // or new SinghBurger();

        // Choose type
        String type = "standard";

        // Create Burger & GarlicBurger
        Burger burger = factory.createBurger(type);
        GarlicBurger garlicBurger = factory.createGarlicBurger(type);

        // Prepare both
        burger.prepare();
        garlicBurger.prepare();

        // Output
        System.out.println("Burger Ready: " + burger);
        System.out.println("Garlic Burger Ready: " + garlicBurger);
    }
}
