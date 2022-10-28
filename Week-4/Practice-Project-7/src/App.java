import java.util.Scanner;

public class App {

    static String inputs; // Declaring an inputs String
    static Scanner sc = new Scanner(System.in); // Declaring variable for input

    public static void main(String[] args) throws Exception {

        Department.makeDepratment();
        // Lab.makeLabs();
        System.out.println("------Welcome to CUI Islamabad Lahore Campus------");
        System.out.println();

        while (true) {
            System.out.printf("--All Deparments--\n\n");
            Department.displayDepratment();
            System.out.printf("\nPress 's' to see the labs in the department\n");
            System.out.printf("Press 'a' to add a new department to this campus\n");
            System.out.printf("Press 'u' to update a department\n");
            System.out.printf("Press 'd' to delete a department\n");
            System.out.printf("Press 'e' to exit\n");

            System.out.print("User Choice: ");
            char userChoice = sc.nextLine().charAt(0);
            int depChoice = 0;
            if (userChoice == 's') {
                System.out.print("Enter the Department Number: ");
                depChoice = sc.nextInt();

                if (depChoice > 0 && depChoice <= Department.departmentArray().length) {
                    ((Department) Department.departmentArray()[depChoice - 1]).departmentMain(depChoice - 1);
                }
            } else if (userChoice == 'a') {
                Department.addDepartment();
            } else if (userChoice == 'u') {
                System.out.print("Enter the Department Number: ");
                depChoice = sc.nextInt();
                sc.nextLine();

                System.out.println("Press 'n' to update Department Name");
                System.out.println("Press 'i' to update Lab Incharge Name");
                System.out.print("Your Choice: ");
                userChoice = sc.nextLine().charAt(0);

                if (userChoice == 'n') {
                    System.out.print("Enter new Department Name: ");
                    inputs = sc.nextLine();
                    Department.updateDepartment(depChoice - 1, inputs, 'D');
                } else if (userChoice == 'i') {
                    System.out.print("Enter new Lab Incharge Name: ");
                    inputs = sc.nextLine();
                    Department.updateDepartment(depChoice - 1, inputs, 'E');
                }

            } else if (userChoice == 'd') {
                System.out.print("Enter the Department Number: ");
                depChoice = sc.nextInt();

                Department.deleteDeparment(depChoice - 1);
            } else if (userChoice == 'e') {
                // File file = new File("Lab.txt");
                // System.out.println(file.exists());
                // File remane = new File("Dep.txt");
                // System.out.println(file.renameTo(remane));
                // ----------------------------------------------
                // File file = new File("data.txt");
                // String[] data = Global.readFromFile(file);
                // String newName = data[0].split("~")[0].replace("Pharmacy", "Computer
                // Science");
                // System.out.println(newName);
                // String a = "Hi my name is Saadaan";
                // String b = a.split(" ")[0].replace(a.split(" ")[0], "Hello");
                // System.out.println(a);
                // System.out.println(b);
                // a = String.join(" ", b,a.split(" ")[1],a.split(" ")[2],a.split("
                // ")[3],a.split(" ")[4]);
                // System.out.println(a);
                // System.out.println(c);

                break;
            } else
                System.out.println("Invalid Input!!!");
            sc.nextLine();

        }
        // System.out.println(Department.displayDepratment());
    }

}