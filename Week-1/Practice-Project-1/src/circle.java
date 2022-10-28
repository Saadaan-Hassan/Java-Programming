public class circle {
    double radius;
    double area;
    double circumference;

    public void setRadius(double rad) {
        if (rad > 0) {
            radius = rad;
        } else {
            System.out.println("Radius can not be negative!");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setCircumference(double cirf) {
        if (cirf > 0) {
            circumference = cirf;
        } else {
            System.out.println("Circumference can not be negative!");
        }
    }

    public double getCircumference() {
        return circumference;
    }

    public void setArea(double a) {
        if (a > 0) {
            area = a;
        } else {
            System.out.println("Area cannot be negative!");
        }
    }

    public double getArea() {
        return area;
    }
}
