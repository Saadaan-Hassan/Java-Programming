public class App {
    public static void main(String[] args) throws Exception {
        Circle c1 = new Circle(3);
        System.out.println(c1);

        Rectangle r1 = new Rectangle(4, 3);
        System.out.println(r1);
        
        Triangle t1 = new Triangle(2, 3);
        System.out.println(t1);
        System.out.println(t1.calArea());    
    
    }
    
    
}
