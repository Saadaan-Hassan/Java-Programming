public class Cirlce extends TwoDShapes{

    private double radius;

    public Cirlce(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI*radius;
    }
}
