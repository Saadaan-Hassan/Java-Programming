package Inheritance_Practice;

import java.util.Comparator;

interface Shapes extends Comparable<Quadrilateral> {
    int a = 0;

   default void display(){
       System.out.println("I am Shapes Class display");
   }

    double area(double length, double width);
    double getArea();
    double perimeter(double length, double width);
    double getPerimeter();



}
