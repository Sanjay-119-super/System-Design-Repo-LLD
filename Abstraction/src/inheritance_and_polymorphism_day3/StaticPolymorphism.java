package inheritance_and_polymorphism_day3;

class Carr{
    protected String brand;
    protected String model;
    protected int currentSpeed;
    protected boolean isEngineOn;

    public Carr() {
        this.brand="Default";
        this.model="Model-X";
        this.currentSpeed=0;
        this.isEngineOn=false;
    }

    //Common methods
    public void start(){
        if (!isEngineOn){
            isEngineOn=true;
            System.out.println("Car is started");
        }
        else {
            System.out.println("Car already started");
        }
    }

    public void stop(){
        if (isEngineOn){
            isEngineOn=false;
            currentSpeed=0;
            System.out.println("Car is stopped");
        }
        else {
            System.out.println("Car is already stopped");
        }
    }

    //static polymorphism || method overloading
    public void accelerate(){
        if (isEngineOn) {
            currentSpeed += 10;
            System.out.println("Car is accelerated: " + currentSpeed);
        }
        else {
            System.out.println("Car start first.");
        }
    }

    public void accelerate(int speed){
        if (isEngineOn && currentSpeed >0){
            currentSpeed+=speed;
            System.out.println("Car is accelerated with speed: " + currentSpeed);
        }
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        Carr carr = new Carr();
        carr.start();
        carr.accelerate();
        carr.accelerate(20);
        carr.start();
    }

}
