import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

    private String employeeId;
    private String employeeName;
    private String employeeDesignation;
    private static ArrayList<String> inputs; // Declaring an inputs array
    private static ArrayList<Employee> employee = new ArrayList<>(); // Declaring Array list for Employees
    private static Scanner sc = new Scanner(System.in);

    // Initialzing 'ids' array for storing dummy ids.
    static String ids[] = { "CSC003", "CSC007", "CSC012", "CSC089", "CSC021", "CSC006", "CSC001", "CSC019", "CSC001",
            "CSC054" };

    // Initialzing 'names' array for storing dummy names.
    static String names[] = { "Saadaan Hassan", "Kabeer Mehmood", "Jawad Hassan", "Arham Atique", "Shafin-uz-Zaman",
            "Zeeshan Zafar", "Ammar Ahmad", "Faizan Mehmood", "Ali Hamza", "Umair Arshad" };

    // Initialzing 'roles' array for storing dummy roles.
    static String roles[] = { "Lecturer", "Lab Attendent", "Professor", "Lab Incharge" };

    public Employee(String employeeId, String employeeName, String employeeDesignation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    // Copy Constructor
    Employee(Employee emp) {
        this.employeeId = emp.employeeId;
        this.employeeName = emp.employeeName;
        this.employeeDesignation = emp.employeeDesignation;
    }

    // Setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;

        if (this.employeeId == emp.employeeId) {
            return true;
        }
        return false;
    }

    @Override
    protected Object clone() {
        Object temp = new Employee(this.employeeId, this.employeeName, this.employeeDesignation);

        return temp;
    }

    @Override
    public String toString() {
        // return String.format("Employee Id= %s, Employee Name= %s , Employee Designation= %s\n", this.employeeId,
        //         this.employeeName, this.employeeDesignation);
        return String.format("%s%%%s%%%s", employeeId, employeeName, employeeDesignation);
    }

    // Populating Employee objects and storing them into an array.
    static void makeEmployee() {
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee(ids[i], names[i], roles[i % roles.length]);
            employee.add(emp);
        }
    }

    static void addEmployee() {
        inputs = new ArrayList<>();

        System.out.print("Enter Employee name: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter Employee ID: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter Employee Designation: ");
        inputs.add(sc.nextLine());

        Employee newEmployee = new Employee(inputs.get(0), inputs.get(1), inputs.get(2));

        employee.add(newEmployee);
    }

    static void addEmployee(Employee emp) {
        employee.add(emp);
    }

    static void displayEmployee() {
        System.out.println(employee);
    }

    static Employee[] getEmployee() {
        Employee emp[] = (Employee[]) employee.toArray();
        return emp;
    }
}
