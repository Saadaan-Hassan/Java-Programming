public class Triangle extends Shapes {
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    // Setters
    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getters
    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    // Calculare Area
    @Override
    public double calArea() {
        return 0.5 * getHeight() * getBase();
    }
}
