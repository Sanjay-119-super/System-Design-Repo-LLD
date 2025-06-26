// strategy for-> walk
public interface WalkRobot {
    void walk();
}

class NormalWalking implements WalkRobot{
    @Override
    public void walk() {
        System.out.println("Robot can walk normally");
    }
}

class NonWalking implements WalkRobot{
    @Override
    public void walk() {
        System.out.println("Robot can not walk..");
    }
}