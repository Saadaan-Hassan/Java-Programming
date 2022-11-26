import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();


        employees.add(new Manager(new Date(1,11,2017), "Mujtaba Zulfiqar", 10000));
        employees.add(new Manager(new Date(20,5,2016), "Muhammad Ahmed Zafar", 20000));
        employees.add(new Manager(new Date(15,5,2015), "Hassan Ali Siddiqui", 30000));
        employees.add(new Manager(new Date(1,3,2014), "Muhammad Zain", 40000));
        employees.add(new Salesman(new Date(7,7,2016), "Ibraheem Bin Haseeb", 2.5, 200000));
        employees.add(new Salesman(new Date(10,5,2014), "Sheraz Ahmad", 2.5, 200000));
        employees.add(new Salesman(new Date(3,3,2014), "Abdul Mateen", 2.5, 200000));
        employees.add(new Salesman(new Date(1,1,2014), "Abdullah Sajjad", 2.5, 200000));

        printPayroll(employees);
        System.out.println();
        System.out.println("============");
        printSortedListOfEmployees(employees);
    }

    public static void printPayroll(ArrayList<Employee> list) {
        int i = 0;
        double totalPayable = 0;

        System.out.println("Sr.\t\tName\t\t\t\t\tSalary");
        System.out.println("=================================================");
        for (Employee emp :
                list) {
            System.out.printf("%d\t\t%s\t\t\t%.2f\n", ++i, emp.getName(), emp.earnings());
            totalPayable+= emp.earnings();
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Summary: Emp: %d\tManagers: %d\tSalesman: %d\n", Manager.getCount()+Salesman.getCount(), Manager.getCount(), Salesman.getCount());
        System.out.printf("Total Payable:\tRs. %.2f", totalPayable);
    }

    public static void printSortedListOfEmployees(ArrayList<Employee> list){
        Collections.sort(list);
        int i=0;
        for (Employee emp :
                list) {
            System.out.printf("%d %s\n",++i, emp);
        }

    }
}