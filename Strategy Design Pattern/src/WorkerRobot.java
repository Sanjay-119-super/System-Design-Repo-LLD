public class WorkerRobot extends Robot{
    public WorkerRobot(TalkRobot talkRobot, WalkRobot walkRobot, FlyRobot flyRobot) {
        super(talkRobot, walkRobot, flyRobot);
    }

    @Override
    public void projection() {
        System.out.println("Worker robot working..");
    }
}
