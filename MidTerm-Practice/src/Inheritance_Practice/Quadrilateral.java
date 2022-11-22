package Inheritance_Practice;

import java.util.InputMismatchException;

public class Quadrilateral implements Shapes {

    private double length;
    private double width;
    private double area;

    static final int temp = 100;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
//        if (width < 0)
//            throw new ArithmeticException("You entered a negative number!");
//            throw new NegativeNumber("You entered a negative number!");
//        else
            this.width = width;
    }

    @Override
    public void display(){
        System.out.println("I am Quadrilateral class display");
    }

    @Override
    public double area(double length, double width) {
        area = length * width;
        return area;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double perimeter(double length, double width) {
        return (2 * length) + (2 * width);
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public int compareTo(Quadrilateral o) {
        int flag =-1;

        if (o.getArea() >= this.getArea())
            flag = 1;
        else if (o.getArea() == this.getArea())
            flag = 0;
        else
            flag = -1;
        return flag;


    }
}
