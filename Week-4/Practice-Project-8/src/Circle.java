public class Circle extends Shapes {
    private double radius;

    // Constructor
    public Circle(double radius) {
        setRadius(radius);
    }

    // Setters
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getters
    public double getRadius() {
        return radius;
    }

    // Calculate Area
    @Override
    public double calArea() {
        return Math.PI * radius * radius;
    }

}
