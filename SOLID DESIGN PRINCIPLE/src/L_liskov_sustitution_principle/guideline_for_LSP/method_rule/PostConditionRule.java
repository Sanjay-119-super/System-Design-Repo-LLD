package L_liskov_sustitution_principle.guideline_for_LSP.method_rule;

class Car {
    protected double speed;

    public Car(double speed) {
        this.speed = speed; // ✅ FIXED: use constructor argument
    }

    public void accelerate() {
        System.out.println("Accelerating..");
        speed += 20;
    }

    public void brake() {
        System.out.println("Applying brake");
        speed -= 20;
    }
}

class HybridCar extends Car {
    private int charge;

    public HybridCar(double speed) {
        super(speed);
        this.charge = 0;
    }

    @Override
    public void accelerate() {
        super.accelerate(); // ✅ Same as parent — LSP followed
    }

    @Override
    public void brake() {
        System.out.println("Applying brake");
        speed -= 20;

        // ❗ LSP Violation: Parent brake() doesn't increase charge
        // This adds extra behavior = **Postcondition modified**
        charge += 10;
    }
}

public class PostConditionRule {
    public static void main(String[] args) {
        HybridCar car = new HybridCar(100);
        car.brake(); // speed = 80, charge = 10 (unexpected from parent view)
    }
}
