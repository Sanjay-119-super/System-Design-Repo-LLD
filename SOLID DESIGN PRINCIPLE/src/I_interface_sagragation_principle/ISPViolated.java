package I_interface_sagragation_principle;

interface Shape{
    double area();
    double volume();
}

class Square implements Shape{

    private double side;

    public Square(double side){
        this.side=side;
    }
    @Override
    public double area() {
        return side*side;
    }

    @Override
    public double volume() {
        throw new RuntimeException("Volume not applicable for square");
    }
}

class Rectangle implements Shape{
    private double l,w;


    public Rectangle(double l, double w){
    this.l=l;
    this.w=w;
}


    @Override
    public double area() {
        return l*w;
    }

    @Override
    public double volume() {
        throw new RuntimeException("Volume not applicable for rectangle");
    }
}

//✅ Area & Volume — both applicable for cube, so it works well.
class Cube implements  Shape{
    private double a;
    public Cube(double a){
        this.a=a;
    }


    @Override
    public double area() {
        return 6*(a*a);
    }

    @Override
    public double volume() {
      return a*a*a;
    }



}

public class ISPViolated {
    public static void main(String[] args) {
        try {
            Shape shape = new Square(5.5);
            shape.area();
            shape.volume();

            Shape shape1 = new Rectangle(10, 29);
            shape1.area();
            shape1.volume();
        }catch (RuntimeException e){
            System.out.println("Error: " + e.getMessage());
        }
        Shape shape2 = new Cube(2);
        shape2.area();
        shape2.volume();


    }
}
