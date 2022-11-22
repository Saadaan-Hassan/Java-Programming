package Inheritance_Practice;

public class Rectangle extends Quadrilateral{

    Rectangle(double length, double width){
        setLength(length);
        setWidth(width);
    }

    public void kichimichi(){
        System.out.println("Kichimichiiiiii");
    }

    @Override
    public String toString() {
        return String.format("\nRectangle:\nArea = %.2f\nPerimeter = %.2f", area(this.getLength(), this.getWidth()), perimeter(this.getLength(), this.getWidth()));
    }
}
