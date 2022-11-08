import java.util.Scanner;

public class Calculator {

    private  Scanner sc = new Scanner(System.in);

    void Add() {
        // Scanner sc = new Scanner(System.in);

        System.out.println("Enter two number: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 + num2);
    }

    void Multiply(){
        // Scanner sc = new Scanner(System.in);

        System.out.println("Enter two number: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1*num2);
    }
}
