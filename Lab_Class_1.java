public class Lab_Class_1{

    public static void main(String args[]){

        System.out.println("Java is interesting"); //After executing statement the cursor is moved to the next line 

        System.out.println("We are using jdk 15.0"); //It is used for printing input messages. After executing statement the cursor remains on the same line

        System.out.println("Intellij is recommended"); //This is used for formatted output. After executing statement the cursor is moved to the next line
    
    // Data Types

    byte b=10;
    short s=20;
    int i=100;
    long l=1000;
    float f=10.0f;
    double d=20.0;
    boolean bl=true;
    char c='a';

    System.out.printf("The value in %d %n", b); //%n is used for new line just like \n. We can also use \n here
    System.out.printf("The value in %d %n", s);
    System.out.printf("The value in %d %n", i);
    System.out.printf("The value in %d %n", l);
    System.out.printf("The value in %f %n", f);
    System.out.printf("The value in %f %n", d);
    System.out.printf("The value in %b %n", bl);
    System.out.printf("The value in %c %n", c);
    }
}