
// strategy for-> fly
public interface FlyRobot {
    void fly();
}

class NormalRobot implements FlyRobot{

    @Override
    public void fly() {
        System.out.println("Flying normally...");
    }
}

class NonFlying implements FlyRobot{
    @Override
    public void fly() {
        System.out.println("Robot can not fly...");
    }
}