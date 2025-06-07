// Step-1 interface for abstraction
interface Car1 {
    void startCar1();

    void stopCar1();

    void shiftGare1(int gare);

    void accelerateCar1(int accelerate);

    void applyBrake();

}

// Step to real world car implementation + data encapsulation data(private)
class RealCar implements Car1{

    //data security by private access modifier
    private boolean isRunning=false;
    private int currentGare=0;
    private int currentSpeed=0;

    @Override
    public void startCar1() {
        if (!isRunning){
            isRunning=true;
            System.out.println("Car is started");
        }
        else {
            System.out.println("Car is already started");
        }
    }

    @Override
    public void stopCar1() {
        if (isRunning){
            isRunning=false;
            currentGare=0;
            currentSpeed=0;
            System.out.println("Car is stop");
        }
        else {
            System.out.println("Car is already stopped.");
        }
    }

    @Override
    public void shiftGare1(int gare) {
        if (isRunning){
            //validate gare
            if (gare > 0 && gare<=6) {
                this.currentGare = gare;
                System.out.println("Shifted to gare: " + gare);
            }
            else {
                System.out.println("Invalid gare shifting please inter valid gare : 0 to 6"+gare);
            }
        }
        else {
            System.out.println("Start the car before shifting gare");
        }
    }

    @Override
    public void accelerateCar1(int accelerate) {
        if (isRunning && accelerate > 0){
            currentSpeed+=accelerate;
            System.out.println("Accelerated the car: " + accelerate + "km/h");
        } else if (currentSpeed==0) {
            System.out.println("shift the gare before accelerating: " + accelerate);
        }
        else {
            System.out.println("Start the car to accelerate");
        }
    }

    @Override
    public void applyBrake() {
        if (isRunning && currentSpeed>0){
            currentSpeed-=10;
            // check current speed
            if (currentSpeed<0) currentSpeed=0;
            System.out.println("brake applied: " + currentSpeed + "km/h");

        }
    }

    //Access the private member by getters & setters

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getCurrentGare() {
        return currentGare;
    }

    public void setCurrentGare(int currentGare) {
        this.currentGare = currentGare;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        if (currentSpeed >=0 && currentSpeed <=300){
            this.currentSpeed=currentSpeed;
        }
        else {
            System.out.println("Invalid speed");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Car1 car1 = new RealCar();
        car1.startCar1();
        car1.shiftGare1(4);
        car1.accelerateCar1(10);
        car1.applyBrake();



        RealCar car = new RealCar();
        car.setCurrentSpeed(200);
        System.out.print("current speed now: "+ car.getCurrentSpeed());

    }
}

/*
Interface (Car1) → Abstraction: Defines what a car can do, hides how it works.

Class (RealCar) → Encapsulation: Protects data (speed, gear, isRunning) using private + getters/setters.

Polymorphism → Used interface reference:
Car1 car = new RealCar(); → future-proof, flexible.

Real-world Logic:

Gear shift only if car is started

Acceleration depends on gear & running state

Brakes reduce speed with lower limit check

Speed capped (0–300 km/h)

*/