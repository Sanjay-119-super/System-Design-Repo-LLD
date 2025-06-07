package I_interface_sagragation_principle;

// todo Now follow 100% Interface sagrigation principle---->
interface TwoDShape{
    double area();
}

interface ThreeDShape{
    double area();
    double volume();
}

class SquareShape2D implements TwoDShape{

    private double side;

    public SquareShape2D(double side){
        this.side=side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Rectangle2D implements TwoDShape{
    private double l,w;

    public Rectangle2D(double l, double w){
        this.l=l;
        this.w=w;
    }

    @Override
    public double area() {
        return l*w;
    }
}

class Cube3D implements ThreeDShape{
    private double a;

    public Cube3D(double a){
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


public class ISPFollow {
    public static void main(String[] args) {

        TwoDShape shape = new SquareShape2D(10);
        double area = shape.area();
        System.out.println("Area of Square: " + area);

        TwoDShape shape1 = new Rectangle2D(5,10);
        double area1 = shape1.area();
        System.out.println("Area of Rectangle: " + area1);

        ThreeDShape threeDShape = new Cube3D(5);
        double area2 = threeDShape.area();
        System.out.println("Area of cube: " + area2);
        double volume = threeDShape.volume();
        System.out.println("Volume of Cube: " + volume);
    }
}
