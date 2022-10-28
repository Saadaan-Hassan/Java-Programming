public class App {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();

        r1.setWidth(5);
        r1.setLength(4);
        r1.setX(0);
        r1.setY(0);

        //Rectngle-2
        Rectangle r2 = new Rectangle();

        r2.setWidth(7);
        r2.setLength(6);
        r2.setX(1);
        r2.setY(1);

        // System.out.println(r1.isIntersect(r2));
        boolean intersect = r1.isIntersect(r2);
        
        if(intersect == true){
            double newArea = r1.intersectArea(r2);
            System.out.println("The area of intersected region is " + newArea);
        }

    }
}
