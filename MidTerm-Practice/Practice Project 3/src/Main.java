import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new CommissionEmployee(1, "Saleem", 25000, 0.06));
        employees.add(new CommissionEmployee(6, "Haleem", 2000, 0.07));
        employees.add(new HourlyEmployee(15, "Kaleem", 45, 25.5));
        employees.add(new CommissionEmployee(4, "Rashid", 26000, 0.08));
        employees.add(new HourlyEmployee(65, "Zaheer", 35, 45));
        employees.add(new HourlyEmployee(76, "Hamza", 39.5, 65.5));


        //Write to File
        File file = new File("MyFile.txt");

//        for (Employee emp :
//                employees) {
//            Global.WriteToFile(file, emp.toString());
//        }

        //Read From File
        ArrayList<String> empData = Global.ReadFromFile(file);

        for (String d :
                empData) {
            if(d!=null)
                System.out.println(d);
        }
        System.out.println("===================================");

        Collections.sort(empData);
        display(empData);
        System.out.println("===================================");
        Collections.reverse(empData);
        display(empData);
        System.out.println("===================================");


        employees.sort(new SortByName());
        displayEmployee(employees);

    }

    public static void display(ArrayList<String> arr){
        for (String  text:
                arr) {
            if(text!=null)
                System.out.println(text);
        }
    }public static void displayEmployee(ArrayList<Employee> arr){
        for (Employee  text:
                arr) {
            if(text!=null)
                System.out.println(text);
        }
    }
}