public class Shapes {
    protected Point point = new Point(0, 0);

    // Setter
    public void setPoint(Point point) {
        this.point = point;
    }

    // Getter
    public Point getPoint() {
        return point;
    }

    //Calculate Area
    public double calArea() {
        return 0.0;
    }

    //To String Function
    @Override
    public String toString() {
        return String.format("Name of Shape: %s, Center Point: %s", this.getClass().getSimpleName(), point);
    }

}
