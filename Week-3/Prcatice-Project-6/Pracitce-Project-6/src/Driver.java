import java.util.Scanner;

public class Driver {
    int logic(int x, int y) {
        int z;
        if (x < y) {
            z = x + y;
        } else {
            z = x - y;
        }

        return z;
    }

    public static void main(String[] args) {
        // Driver saadan=new Driver();

        // int a=4;
        // int b=5;
        // int c=saadan.logic(a,b);
        // System.out.println(c);

        // int marks[] = { 20, 40, 60, 80, 100 };
        // int sum = 0;

        // for (int element : marks) {
        //     sum = sum + element;
        // }
        // System.out.println("Total marks of student is " + sum);

        // int num = 80;
        // boolean check = false;

        // for (int element : marks) {
        //     if (element == num) {
        //         check = true;
        //     }
        // }

        // System.out.println(num + (check == true ?(" is present."):(" is not present.")));

        // int arr[] = {1,2,3,4,5,6,7,8};
        // int l = arr.length;
        // int n = Math.floorDiv(l, 2);
        // int temp;

        // for (int i = 0; i < n; i++) {
        //     temp = arr[i];
        //     arr[i] = arr[l-1-i];
        //     arr[l-1-i] = temp;
        // }

        // for (int element : arr) {
        //     System.out.println(element);
        // }
    
        Scanner sc = new Scanner(System.in);
        char inp;

        System.out.print("Enter a character: ");
        inp = sc.next().charAt(0);
        int add = (int)inp +8;
        char enc = (char)add;
        System.out.println("input is "+ enc);
    }
}
