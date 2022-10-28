public class App {
    public static void main(String args[]) {

        // -----Circle.java-----
        circle c1 = new circle();

        System.out.println(c1);
        System.out.println(c1.radius);

        c1.radius = 20.43;
        System.out.println(c1.radius);

        c1.setRadius(290.43);
        // System.out.println(c1.radius);
        System.out.printf("Radius of circle 1 is %.2f\n", c1.getRadius());

        c1.setCircumference(30.4);
        System.out.printf("Circumference of circle 1 is %.2f\n", c1.getCircumference());

        circle c2 = new circle();

        c2.setArea(20.50);
        System.out.printf("Area of circle 2 is %.2f\n", c2.getArea());

        // -----Students.java-----
        Students s1 = new Students();

        s1.setName("Saadaan");
        s1.setAge(18);
        s1.setCGPA(3.64f);
        System.out.printf("The name of student is " + s1.getName() + ". The age of Student is " + s1.getAge() + ". The cgpa of student is " + s1.getCGPA() + "%n");
    }
}
