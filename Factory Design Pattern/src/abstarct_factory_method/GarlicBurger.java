package abstarct_factory_method;

// Product B
public interface GarlicBurger {
    void prepare();
}

// --- Concrete Garlic Burgers ---
class BasicGarlicBurger implements GarlicBurger {
    @Override
    public void prepare() {
        System.out.println("Basic Garlic Burger");
    }

    @Override
    public String toString() {
        return "BasicGarlicBurger{}";
    }
}

class BasicGarlicCheeseBurger implements GarlicBurger {
    @Override
    public void prepare() {
        System.out.println("Basic Garlic Cheese Burger");
    }

    @Override
    public String toString() {
        return "BasicGarlicCheeseBurger{}";
    }
}
