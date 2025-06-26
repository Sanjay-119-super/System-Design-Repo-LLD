 class CompanionRobot extends Robot{

    public CompanionRobot(TalkRobot talkRobot, WalkRobot walkRobot, FlyRobot flyRobot){
        super(talkRobot,walkRobot,flyRobot);
    }
     @Override
     public void projection() {
         System.out.println("Companion Robot start...");
     }
 }
