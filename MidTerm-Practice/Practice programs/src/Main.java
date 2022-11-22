import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TwoDShapes [] shapes = new TwoDShapes[2];

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius of circle: ");
        double radius = sc.nextDouble();

        System.out.print("Enter the length of rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter the width of rectangle: ");
        double width = sc.nextDouble();

        shapes[0] = new Cirlce(radius);
        shapes[1] = new Rectangle(length, width);
        
        TwoDShapes s1 = new Circle();
    }
}
