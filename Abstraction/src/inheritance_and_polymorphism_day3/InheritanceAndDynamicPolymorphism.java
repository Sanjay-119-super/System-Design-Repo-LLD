package inheritance_and_polymorphism_day3;

//superCar
abstract class Car{
    // why? for child class can access private members
    protected String brandName;
    protected String modelName;
    protected int currentSpeed;
    protected boolean isOnEngine;

    // public constructor
    public Car(String brandName, String modelName, int currentSpeed, boolean isOnEngine) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.isOnEngine = isOnEngine;
    }

    // common methods for cars (child classes)
    public void startCar(){
        isOnEngine=true;
        System.out.println(brandName + " " + modelName + " "+ "Started."  );
    }

    public void stopCar(){
        isOnEngine=false;
        currentSpeed=0;
        System.out.println(brandName + " " + modelName + " " + "Stopped.");
    }

    // abstract method for child class customization || Dynamic Polymorphism
    public abstract void accelerate();
    public abstract void applyBrake();

}

//todo Child-class=> ManualCar inherit Car
class ManualCar extends Car{
    private int currentGare=0; // only should access ManualCar

    public ManualCar(String brandName, String modelName, int currentSpeed, boolean isOnEngine) {
        super(brandName, modelName, currentSpeed, isOnEngine);
    }

    //specific method for only ManualCar
    public void shiftGare(int gare){
        if (gare >0 && gare<=6){
            currentGare=gare;
            System.out.println("Gare shift to: " + currentGare);
        }
        else {
            System.out.println("invalid gare! please enter gare 0 to 6.");
        }
    }

    // implementing DYNAMIC polymorphism
    @Override
    public void accelerate() {
        if (isOnEngine){
            currentSpeed+=(5*currentGare);
            System.out.println("ManualCar applying accelerating: " + currentSpeed + "km/h");
        }
        else {
            System.out.println("Start the car first.");
        }
    }

    // implementing DYNAMIC polymorphism
    @Override
    public void applyBrake() {
        if (currentSpeed > 0){
            currentSpeed-=10;
            System.out.println("ManualCar applying brake: " + currentSpeed + "km/h");
        }
        else {
            System.out.println("Car is already stopped.");
        }
    }
}

//todo Child class-ElectricCar==>inherit Car
class ElectricCar extends Car{
    private int batteryLevel=100;

    public ElectricCar(String brandName, String modelName, int currentSpeed, boolean isOnEngine) {
        super(brandName, modelName, currentSpeed, isOnEngine);
    }

    //Specific method for only ElectricCar class
    public void chargeBattery(){
        System.out.println("E. Car charge level: " + batteryLevel);
    }

    @Override
    public void accelerate() {
        if (isOnEngine && batteryLevel>10){
            currentSpeed+=15;
            batteryLevel-=10;
            System.out.println("Electric Car applying accelerating. Speed: " + currentSpeed + "km/h");
        }
        else {
            System.out.println("E. Car already stopped");
        }
    }

    @Override
    public void applyBrake() {
        if (currentSpeed>0){
            currentSpeed-=10;
            System.out.println("E. Car applying break. Speed: " + currentSpeed + "km/h");
        }
    }
}


public class InheritanceAndDynamicPolymorphism {
    public static void main(String[] args) {
        //Manual Car TEST
        ManualCar car = new ManualCar("Suzuki" , "Swift", 0,false);
        car.startCar();
        car.shiftGare(4);
        car.accelerate();
        car.applyBrake();
        car.stopCar();

        System.out.println("-------------------");

        //Electric Car Test
        ElectricCar electric = new ElectricCar("Tesla","Model- Y",0,false);
        electric.startCar();
        electric.chargeBattery();
        electric.accelerate();
        electric.applyBrake();
        electric.stopCar();
        electric.chargeBattery();
    }
}
