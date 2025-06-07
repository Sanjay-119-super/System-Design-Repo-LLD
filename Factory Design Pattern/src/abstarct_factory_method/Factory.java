package abstarct_factory_method;

// Abstract Factory
public interface Factory {
    Burger createBurger(String type);
    GarlicBurger createGarlicBurger(String type);
}

// --- Factory 1: SinghBurger ---
class SinghBurger implements Factory {

    @Override
    public Burger createBurger(String type) {
        switch (type.toLowerCase()) {
            case "basic": return new BasicBurger();
            case "standard": return new StandardBurger();
            case "premium": return new PremiumBurger();
            default: throw new IllegalArgumentException("Invalid Burger type: " + type);
        }
    }

    @Override
    public GarlicBurger createGarlicBurger(String type) {
        if (type.equalsIgnoreCase("basic"))
            return new BasicGarlicBurger();
        else
            return new BasicGarlicCheeseBurger();
    }
}

// --- Factory 2: KingBurger (Wheat-based + Garlic) ---
class KingBurger implements Factory {

    @Override
    public Burger createBurger(String type) {
        switch (type.toLowerCase()) {
            case "basic": return new BasicWheatBurger();
            case "standard": return new StandardWheatBurger();
            case "premium": return new PremiumWheatBurger();
            default: throw new IllegalArgumentException("Invalid Burger type: " + type);
        }
    }

    @Override
    public GarlicBurger createGarlicBurger(String type) {
        if (type.equalsIgnoreCase("basic"))
            return new BasicGarlicBurger();
        else
            return new BasicGarlicCheeseBurger();
    }
}
