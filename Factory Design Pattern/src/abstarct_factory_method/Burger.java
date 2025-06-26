package abstarct_factory_method;

// Product A
public interface Burger {
    void prepare();
}

// --- Concrete Products for Burger ---
class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic Burger");
    }

    @Override
    public String toString() {
        return "BasicBurger{}";
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Standard Burger");
    }

    @Override
    public String toString() {
        return "StandardBurger{}";
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium Burger");
    }

    @Override
    public String toString() {
        return "PremiumBurger{}";
    }
}

// --- Concrete Wheat-Based Burgers ---
class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic Wheat Burger");
    }

    @Override
    public String toString() {
        return "BasicWheatBurger{}";
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Standard Wheat Burger");
    }

    @Override
    public String toString() {
        return "StandardWheatBurger{}";
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium Wheat Burger");
    }

    @Override
    public String toString() {
        return "PremiumWheatBurger{}";
    }
}
