package L_liskov_sustitution_principle.guideline_for_LSP.signature_Rule;

class Vehicle{
    public Vehicle getDetail(){
        System.out.println("Parent Vehicle");
        return new  Vehicle();
    }
}

// Child class with covariant return type
class  Car extends Vehicle{
    @Override
    public Vehicle getDetail() {
        System.out.println("Child Vehicle");
        return new Car();
    }
}

class Client1{
    private Vehicle vehicle;

    public Client1(Vehicle vehicle){
        this.vehicle=vehicle;
    }
    public void showDetail(){
        Vehicle detail = vehicle.getDetail();
    }
}

public class ReturnType {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();

        Client1 client1 = new Client1(car);
        client1.showDetail();
        Client1 client2 = new Client1(vehicle);
        client2.showDetail();
    }
}
