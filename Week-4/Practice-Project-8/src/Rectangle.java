public class Rectangle extends Shapes {
    private double lenght;
    private double width;

    // Constructor
    public Rectangle(double lenght, double width) {
        setLenght(lenght);
        setWidth(width);
    }

    // Setters
    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Getters
    public double getLenght() {
        return lenght;
    }

    public double getWidth() {
        return width;
    }

    // Calculate Area
    @Override
    public double calArea() {
        return lenght * width;
    }

}
