

abstract class Robot{
    private TalkRobot talkRobot;
    private WalkRobot walkRobot;
    private FlyRobot flyRobot;

    public Robot(TalkRobot talkRobot, WalkRobot walkRobot, FlyRobot flyRobot) {
        this.talkRobot = talkRobot;
        this.walkRobot = walkRobot;
        this.flyRobot = flyRobot;
    }

    //deligate methods
    public void talk(){
        talkRobot.talk();
    }
    public void walk(){
        walkRobot.walk();
    }
    public void fly(){
        flyRobot.fly();
    }

    public abstract void  projection();
}

public class RobotApp {
    public static void main(String[] args) {
        //Companion Robot
        System.out.println("------Companion Robot----");
        Robot companion = new CompanionRobot(
                new NonTalking(),
                new NonWalking(),
                new NonFlying()
        );
        companion.walk();
        companion.talk();
        companion.fly();
        System.out.println();

        //Worker Robot
        Robot worker = new WorkerRobot(
                new NonTalking(),
                new NonWalking(),
                new NonFlying()
        );
        System.out.println("-------Worker Robot----------");
        worker.talk();
        worker.walk();
        worker.fly();
    }
}
