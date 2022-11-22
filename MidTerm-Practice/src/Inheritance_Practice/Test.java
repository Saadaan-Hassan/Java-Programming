package Inheritance_Practice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** <h1>Inheritance</h1>
 * <p>In java multi-inheritance is not allowed but can be achieved through interfaces.</p>
 * <br>
 * <p><b>Points to be noted:</b></p>
 * <p>1) Inheritance is "Is-A relation"</p>
 * <p>2) In inheritance private methods and variables are not inherited</p>
 * <p>3) In inheritance by default Parent class' default constructor is called by constructors of child classes</p>
 * <p>4) If the data type of object is Parent and the constructor call is of Child then only those methods are accessible which are present in both or in Parent Class. (Child Class methods are not accessible in this case) This is also called "Polymorphism"</p>
 * <br>
 * <h2>Abstract & Interface:</h2>
 * <p>=> Abstract function is one which is not declared but only its function header is written.</p>
 * <p>=> To use an abstract Method in a class, the class must also be set to abstract or interface.</p>
 * <p>=> An abstract class contain one or more abstract methods as well as concrete methods</p>
 * <p>=> An interface contains only abstract methods.</p>
 * <br>
 * <b>Important Note:</b>
 * <p>* To inherit an Abstract Class to a class use "extends" keyword.</p>
 * <p>* To inherit an Interface to a class use "implements" keyword.</p>
 * <p>* To inherit an Interface to an other Interface use "extends" keyword.</p>
 */
public class Test {
    public static void main(String[] args) {
        Quadrilateral quad = new Quadrilateral();
        System.out.println(quad);

        //Polymorphism
        Quadrilateral rectangle = new Rectangle(0,0);
        Scanner sc = new Scanner(System.in);
        rectangle.setLength(12);
        System.out.print("Enter Width: ");
        double n = sc.nextDouble();
        rectangle.setWidth(n);
        System.out.println(rectangle);
        System.out.println("===============");

        Quadrilateral square = new Square(1,3);
        square.setWidth(23.67);
        square.setLength(26.45);
        System.out.println(square);
        System.out.println("===============");

        Quadrilateral parallelogram = new Parallelogram(0,0);
        parallelogram.setLength(12);
        parallelogram.setWidth(23);
        ((Parallelogram)parallelogram).setAngle(Math.PI/4); // Angle in radians
        System.out.println(parallelogram);
        System.out.println("===============");

/*----------------------------------------------------------------------------*/
        ArrayList<Quadrilateral> quads= new ArrayList<Quadrilateral>();
        quads.add(new Rectangle(12, 21));
        quads.add(new Parallelogram(32,14));
        quads.add(new Square(4,5));
        display(quads);

        System.out.println("===============");
        System.out.println("After sorting the list");
        Collections.sort(quads);    // By Using Comparable
        display(quads);


    }

    static void display(ArrayList<Quadrilateral> arr){
        for (Quadrilateral q :
                arr) {
            System.out.println(q);
            System.out.println("==============");
        }
    }
}
