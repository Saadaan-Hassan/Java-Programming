import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    private String departmentName;
    private Lab labs[];
    public Employee labsIncharge;

    // Declaring Array list for Departments
    static ArrayList<Department> department = new ArrayList<>();
    static ArrayList<String> inputs = new ArrayList<>();
    // Initialzing 'departments' array for storing dummy department names.
    static String departments[] = { "Computer Science", "Pharmacy", "Computer Engineering", "Architecture" };
    // Initialzing 'names' array for storing dummy names.
    static String names[] = { "Saadaan Hassan", "Kabeer Mehmood", "Jawad Hassan", "Arham Atique", "Shafin-uz-Zaman",
            "Zeeshan Zafar", "Ammar Ahmad", "Faizan Mehmood", "Ali Hamza", "Umair Arshad" };
    // Initialzing 'labNames' array for storing dummy lab names.
    static String labNames[] = { "PC-1", "C-1", "C-15", "C-3", "C-7", "C-17", "C-22", "C-2", "PC-3", "A-5" };

    private static SecureRandom rn = new SecureRandom();
    private static Scanner sc = new Scanner(System.in);
    // Populating Department Objects and storing them into an array.

    public Department(String departmentName, Employee labsIncharge, Lab[] labs) {
        this.departmentName = departmentName;
        this.labsIncharge = labsIncharge;
        this.labs = labs;
    }

    // Copy Constructor
    public Department(Department dep) {
        this.departmentName = dep.departmentName;
        this.labs = dep.labs;
        this.labsIncharge = dep.labsIncharge;
    }

    static File file = new File("data.txt");

    // Department Main
    public void departmentMain(int deptNumber) throws IOException {
        // for (int i = 0; i < departments.length; i++) {
        // Global.writeToFile(file, ((Department) department.toArray()[i]).toString());
        // }
        while (true) {
            System.out.printf("\nYou are in %s Department\n\n", this.departmentName);
            System.out.printf("--All Labs in this Deparment--\n\n");

            Lab.displayLabs(deptNumber);

            System.out.printf("\nPress the 's' to see the computers in the lab\n");
            System.out.println("Press 'a' to assign a new lab to this departement");
            System.out.println("Press 'u' to update a lab");
            System.out.println("Press 'd' to update a lab");
            System.out.println("Press 'r' to return");
            System.out.print("User Choice: ");
            char userChoice = sc.nextLine().charAt(0);
            int labChoice = 0;
            if (userChoice == 's') {
                System.out.print("Enter the Lab number: ");
                labChoice = sc.nextInt();
                sc.nextLine();
                if (labChoice > 0 && labChoice <= Lab.labsArray().length) {
                    ((Lab) Lab.labsArray()[labChoice - 1]).labMain(deptNumber, labChoice-1);
                }
            } else if (userChoice == 'a') {
                Lab.addLab(deptNumber);
            } else if (userChoice == 'u') {
                System.out.print("Enter the Lab Number: ");
                labChoice = sc.nextInt();
                sc.nextLine();

                System.out.println("Press 'l' to update Lab Name");
                System.out.println("Press 'a' to update Lab Attendent Name");
                System.out.print("Your Choice: ");
                userChoice = sc.nextLine().charAt(0);

                String name = "";

                if (userChoice == 'l') {
                    System.out.print("Enter new Lab Name: ");
                    name = sc.nextLine();

                    Lab.updateLab(deptNumber, labChoice - 1, name, 'L');

                } else if (userChoice == 'a') {
                    System.out.print("Enter new Lab Attendent Name: ");
                    name = sc.nextLine();
                    Lab.updateLab(deptNumber, labChoice - 1, name, 'E');

                }

            } else if (userChoice == 'd') {
                System.out.print("Enter the Lab Number: ");
                labChoice = sc.nextInt();
                sc.nextLine();
                Lab.deleteLab(deptNumber, labChoice - 1);
            } else if (userChoice == 'r') {
                break;
            } else
                System.out.println("Invalid Input!");
        }

    }

    // Make Departments
    public static void makeDepratment() throws IOException {
        Lab.makeLabs();

        for (int i = 0; i < departments.length; i++) {
            Department dep = new Department(departments[i],
                    new Employee(Integer.toString(rn.nextInt(1000)), names[i], "Lab Incharge"),
                    Lab.assignLabs());

            department.add(dep);
        }
        // String depArray[] = Global.readFromFile(file);
        // for (int i = 0; i < depArray.length; i++) {
        // Department dep = new Department(depArray[i].split(",")[0],
        // depArray[i].split(",")[0],depArray[i].split(",")[0]);
        // department.add(null)

        // }

    }

    // Add Department Method
    public static void addDepartment() throws IOException {
        inputs = new ArrayList<>();
        System.out.print("Enter the Department Name: ");
        inputs.add(sc.nextLine());
        System.out.print("Enter the Lab Incharge Id: ");
        inputs.add(sc.nextLine());
        System.out.print("Enter the Lab Incharge Name: ");
        inputs.add(sc.nextLine());

        Department newDepartment = new Department(inputs.get(0),
                new Employee(inputs.get(1), inputs.get(2), "Lab Incharge"), Lab.assignLabs());

        department.add(newDepartment);
        Global.writeToFile(file, newDepartment.toString());

    }

    // Update Department
    public static void updateDepartment(int index, String name, char category) throws IOException {
        String[] data = Global.readFromFile(file);
        file.delete();
        File file = new File("data.txt");
        if (category == 'D') {
            String oldName = data[index].split("~")[0];
            String newName = data[index].split("~")[0].replaceAll(oldName, name);

            // System.out.println(newName);
            data[index] = String.join("~", newName, data[index].split("~")[1], data[index].split("~")[2]);

        } else if (category == 'E') {
            String oldName = data[index].split("~")[1].split("%")[2];
            String newName = oldName.replace(oldName, name);

            // System.out.println(newName);
            String newEmployeeData = String.join("%", data[index].split("~")[2].split("%")[0], newName,
                    data[index].split("~")[2].split("%")[2]);

            data[index] = String.join("~", data[index].split("~")[0], data[index].split("~")[1], newEmployeeData);
        }
        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }
    }

    // Delete Department
    public static void deleteDeparment(int index) throws IOException {
        String[] data = Global.readFromFile(file);
        file.delete();
        File file = new File("data.txt");
        for (int j = 0; j < data.length; j++) {
            if (j == index) {
                continue;
            }
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }

    }

    // Display the Departments
    public static void displayDepratment() throws IOException {
        // for (int j = 0; j < department.toArray().length; j++) {
        // System.out.printf("%d- %s\n", j + 1, department.toArray()[j].toString());
        // }

        String[] data = Global.readFromFile(file);
        int j = 0;
        String[] splitStr;

        for (String string : data) {
            if (string != null) {
                splitStr = string.split("~");
                System.out.printf("%d- Department Name: %s\n   No. of Labs: %s\n   Lab Incharge: %s\n", j + 1,
                        splitStr[0], Math.round(splitStr[1].split("&").length / 2), splitStr[2].split("%")[1]);
                j++;
            }
        }

        // System.out.println(data.length);
    }

    // Return department array list as an object array
    public static Object[] departmentArray() {
        return department.toArray();
    }

    // Setters
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    public void setLabsIncharge(Employee labsIncharge) {
        this.labsIncharge = labsIncharge;
    }

    // Getters
    public String getDepartmentName() {
        return departmentName;
    }

    public Lab[] getLabs() {
        return labs;
    }

    public Employee getLabsIncharge() {
        return labsIncharge;
    }

    // toString Method
    @Override
    public String toString() {
        String labStr = "";
        for (Lab lab : Lab.labs) {
            labStr = labStr + lab.toString();
        }
        return String.format("%s~%s~%s", departmentName, labStr, labsIncharge);
    }

    // clone method
    @Override
    protected Object clone() {
        Object temp;

        temp = new Department(this.departmentName, this.labsIncharge, this.labs);
        return temp;
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        Department dep = (Department) obj;
        if (this.departmentName == dep.departmentName)
            return true;
        return false;
    }

}