package Inheritance_Practice;

public class Parallelogram extends Quadrilateral {

    private double angle;

//Constructor
    Parallelogram(){}
    Parallelogram(double length, double width){
        setLength(length);
        setWidth(width);
    }

    Parallelogram(double length, double width, double angle){
        setLength(length);
        setWidth(width);
        setAngle(angle);
    }
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public double getArea(){
        if(angle != 0)
            return area(getLength(), getWidth(), getAngle());
        else
            return area(getLength(), getWidth());
    }

    public double area(double length, double width, double angle){
        return length * width * Math.sin(angle);
    }
    @Override
    public double area(double length, double height) {
        return super.area(length, height);
    }

    @Override
    public String toString() {
        return String.format("\nParallelogram:\nArea = %.2f\nPerimeter = %.2f", getArea(), perimeter(this.getLength(), this.getWidth()));
    }
}
