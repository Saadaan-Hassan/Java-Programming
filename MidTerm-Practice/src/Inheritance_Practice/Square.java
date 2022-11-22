package Inheritance_Practice;

public class Square extends Quadrilateral{

    public Square(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public String toString() {
        return String.format("\nSquare:\nArea = %.2f\nPerimeter = %.2f", area(this.getLength(), this.getWidth()), perimeter(this.getLength(), this.getWidth()));
    }
}
