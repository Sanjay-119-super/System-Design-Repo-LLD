interface Car{
    void startCar();
    void stopCar();
    void shiftGare(int gare);
    void applyBreak();
    void accelerate(int accelerate);

}

class SuperCar implements Car{
    private boolean isRunning=false;
    private int currentSpeed=0;
    private int currentGare=0;


    @Override
    public void startCar() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("Car started : Ready to go");
        }
        else {
            System.out.println("Car is already started.");
        }
    }

    @Override
    public void stopCar() {
        if (isRunning){
            isRunning=false;
            currentGare=0;
            currentSpeed=0;
            System.out.println("Car is stop");
        }
        else {
            System.out.println("Car already stopped");
        }
    }

    @Override
    public void shiftGare(int gare) {
        if (isRunning){

            if (gare >=0 && gare<=6){
                currentGare=gare;
                System.out.println("Shifted to gare: " + gare);
            }
            else {
                System.out.println("Invalid gare choose between 0-6");
            }

        }
        else {
            System.out.println("Start the car first before shifting gears.");
        }
    }

    @Override
    public void applyBreak() {
        if (isRunning && currentSpeed > 0){
            currentSpeed-=20;
            if (currentSpeed<0) currentSpeed=0;
            System.out.println("Brake Applied: " + currentSpeed + "km/h");
        }
        else {
            System.out.println("Car is not moving or already stopped");
        }
    }



    @Override
    public void accelerate(int accelerate) {
        if (isRunning && currentGare >0){
            currentSpeed+=20;
            System.out.println("accelerated : " + currentSpeed + "km/h");
        } else if (currentSpeed==0) {
            System.out.println("shift to gare before accelerating");
        }
        else {
            System.out.println("Start the care before accelerating");
        }
    }


}

class CheckCar{
    public static void main(String[] args) {
        Car car = new SuperCar();
        car.startCar();
        car.shiftGare(2);
        car.accelerate(20);
        car.applyBreak();

        car.stopCar();
    }
}

/*
Abstraction	Interface Car defines what a car can do (start, stop, gear, etc.)
encapsulation_day_2.Encapsulation	All car properties (speed, gear, isRunning) are private and only accessible through methods
Polymorphism	Car car = new SuperCar(); → promotes loose coupling & flexibility
(Inheritance - optional)	If more car types are added (e.g. ElectricCar, RaceCar), can reuse this structure

---------------
Cannot accelerate or shift gear unless car is started
Can only shift to valid gears (0–6)
Brakes reduce speed in steps (like real car)
Uses logic checks to simulate safe driving behavior
*/