import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    App() {
        // System.out.println(5/a);
        // throw new ArithmeticException("Invalid!!!");
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
        App obj = new App();
        int result = obj.divide();
        System.out.println(result);
        }catch(ArithmeticException e){
        System.out.println(e.getMessage());
        }catch(InputMismatchException e){
        System.out.println("Invalid Input!!!");
        }
        finally{
        System.out.println("The program is ended");
        }

    }

    int divide() {
        int a, b;

        System.out.print("Enter number-1: ");
        a = sc.nextInt();
        System.out.print("Enter number-2: ");
        b = sc.nextInt();
        return a / b;
    }
}
