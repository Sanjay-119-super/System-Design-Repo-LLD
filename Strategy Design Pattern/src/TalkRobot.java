
// strategy for-> talk
public interface TalkRobot {
   void talk();
}

class NormalTalk implements TalkRobot{
    @Override
    public void talk() {
        System.out.println("Robot can talk normally..");
    }
}

class NonTalking implements TalkRobot{
    @Override
    public void talk() {
        System.out.println("Robot can not Talk");
    }
}