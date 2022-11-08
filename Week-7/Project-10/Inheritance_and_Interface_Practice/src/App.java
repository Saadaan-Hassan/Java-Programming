/*
Create a class with a method that prints "This is parent class" and its subclass with another method that prints "This is child class". Now, create an object for each of the class and call
1 - method of parent class by object of parent class
2 - method of child class by object of child class
3 - method of parent class by object of child class
*/

public class App {
    public static void main(String[] args) throws Exception {
        Parent p1 = new Child();
        p1.parentCall();
        p1.display();

        Child c1 = new Child();
        c1.childCall();
        c1.biryani();
        c1.salad();
        c1.spoon();
    }
}
