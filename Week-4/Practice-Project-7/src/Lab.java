import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;;

public class Lab {
    private String labName;
    private Employee labAttendent;
    PCSystem computers[];

    static ArrayList<String> inputs; // Declaring an inputs array
    static ArrayList<Lab> labs = new ArrayList<>(); // Declaring Array list for Labs
    static Scanner sc = new Scanner(System.in);
    // Initialzing 'labNames' array for storing dummy lab names.
    static String labNames[] = { "PC-1", "C-1", "C-15", "C-3", "C-7", "C-17", "C-22", "C-2", "PC-3", "A-5" };
    // Initialzing 'ids' array for storing dummy ids.
    static String ids[] = { "CSC003", "CSC007", "CSC012", "CSC089", "CSC021", "CSC006", "CSC001", "CSC019", "CSC001",
            "CSC054" };
    // Initialzing 'serialNumber' array for storing dummy serial numbers.
    static String serailNumber[] = { "CS10023", "CS10034", "CS34322", "CS40324", "CS93204", "CS12432", "EE43234",
            "PY32439", "SE21424", "PH32480" };
    // Initialzing 'company' array for storing dummy company names.
    static String company[] = { "HP", "Dell", "Lenovo", "Asus" };
    // Initialzing 'names' array for storing dummy names.
    static String names[] = { "Saadaan Hassan", "Kabeer Mehmood", "Jawad Hassan", "Arham Atique", "Shafin-uz-Zaman",
            "Zeeshan Zafar", "Ammar Ahmad", "Faizan Mehmood", "Ali Hamza", "Umair Arshad" };

    // Initialzing 'size' array for storing dummy sizes for ram and hard disk.
    static int size[] = { 4000, 2000, 8000, 32000, 16000 };
    // Initialzing 'option' array for storing boolean values.
    static boolean option[] = { true, false };

    private static SecureRandom rn = new SecureRandom();

    public Lab(String labName, Employee labAttendent, PCSystem[] computers) {
        this.labName = labName;
        this.labAttendent = labAttendent;
        this.computers = computers;
    }

    // Copy Constructor
    public Lab(Lab lab) {
        this.labName = lab.labName;
        this.labAttendent = lab.labAttendent;
        this.computers = lab.computers;
    }

    private static File file = new File("data.txt");

    // Lab Main
    public void labMain(int deptIndex, int labIndex) throws IOException {

        // for (int i = 0; i < labNames.length; i++) {
        // Global.writeToFile(file, labs.toArray()[i].toString());
        // }
        while (true) {
            System.out.printf("\nI am in %s Lab\n", this.labName);
            System.out.printf("\n--All Systems in this Lab--\n\n");

            PCSystem.displaySystems(deptIndex, labIndex);

            System.out.println("Press 'a' to assign a new System for this Lab");
            System.out.println("Press 'd' to delete a System");
            System.out.println("Press 'r' to return");
            System.out.print("Your Choice: ");
            char userChoice = sc.nextLine().charAt(0);
            int choiceInt = 0;
            if (userChoice == 'a') {
                PCSystem.addSystem(deptIndex, labIndex);
                PCSystem.displaySystems(deptIndex, labIndex);
            } else if (userChoice == 'd') {

                System.out.print("Enter the System Number: ");
                choiceInt = sc.nextInt();
                sc.nextLine();

                PCSystem.deleteSystem(deptIndex, labIndex, choiceInt);
            } else if (userChoice == 'r') {
                break;
            } else
                System.out.println("Invalid Input");
        }

    }

    // Make Labs
    public static void makeLabs() {
        PCSystem.makeSystem();

        for (int i = 0; i < 10; i++) {
            Lab lab = new Lab(labNames[rn.nextInt(10)],
                    new Employee(Integer.toString(rn.nextInt(1000)), names[rn.nextInt(10)], "Lab Attendent"),
                    PCSystem.assignSystems());
            labs.add(lab);
        }
    }

    // Display the Labs
    public static void displayLabs(int deptNumber) throws IOException {
        // for (int j = 0; j < labs.toArray().length; j++) {
        // System.out.printf("%d- %s\n", j + 1, labs.toArray()[j].toString());
        // }
        String[] data = Global.readFromFile(file);

        int j = 0;
        String[] labArr;
        String name;

        String requiredDept = data[deptNumber];
        if (requiredDept != null) {
            labArr = requiredDept.split("~")[1].split("!");
            String labStr[]; 
            for (int i = 0; i < labArr.length; i++) {
                labStr = labArr[i].split("&");
                name = labStr[0];
                String emp = labArr[i].split("&")[1].split("%")[1];

                int systemsLength = labArr[i].split("#").length;

                System.out.printf("%d- Lab Name: %s\n   No. of Systems: %s\n   Lab Attendent: %s\n", j + 1, name,
                        systemsLength, emp);
                j++;
            }

        }

    }

    // Add Lab Method
    public static void addLab(int deptNumber) throws IOException {
        inputs = new ArrayList<>();

        System.out.print("Enter the Lab Name: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter the Lab Attendent Name: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter the Lab Attendent Id: ");
        inputs.add(sc.nextLine());

        Lab newLab = new Lab(inputs.get(0), new Employee(inputs.get(1), inputs.get(2), "Lab Attendent"),
                PCSystem.assignSystems());

        labs.add(newLab);

        String data[] = Global.readFromFile(file);

        file.delete();

        File file = new File("data.txt");

        String labArr[] = data[deptNumber].split("~")[1].split("!");
        String labStr = "";

        for (int i = 0; i < labArr.length; i++) {
            labStr = labStr + labArr[i] + "!";
        }

        labStr = labStr + newLab.toString() + "!";

        data[deptNumber] = String.join("~", data[deptNumber].split("~")[0], labStr, data[deptNumber].split("~")[2]);

        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }

    }

    // Update Lab Method
    public static void updateLab(int depIndex, int labIndex, String name, char category) throws IOException {
        String[] data = Global.readFromFile(file);
        String oldName = "";
        String newName = "";
        String[] labsArr = data[depIndex].split("~")[1].split("!");
        String labStr = "";

        file.delete();
        File file = new File("data.txt");

        if (category == 'L') {
            oldName = labsArr[labIndex].split("&")[0];
            newName = oldName.replace(oldName, name);

            labsArr[labIndex] = String.join("&", newName, labsArr[labIndex].split("&")[1],
                    labsArr[labIndex].split("&")[2]);

            for (String labs : labsArr) {
                labStr = labStr + labs + "!";
            }

            data[depIndex] = String.join("~", data[depIndex].split("~")[0], labStr, data[depIndex].split("~")[2]);

        } else if (category == 'E') {
            String[] emp = labsArr[labIndex].split("&")[1].split("%");
            oldName = emp[1];
            newName = oldName.replace(oldName, name);

            String newEmployeeData = String.join("%", emp[0], newName, emp[2]);

            labsArr[labIndex] = String.join("&", labsArr[labIndex].split("&")[0], newEmployeeData,
                    labsArr[labIndex].split("&")[2]);

            for (String labs : labsArr) {
                labStr = labStr + labs + "!";
            }

            data[depIndex] = String.join("~", data[depIndex].split("~")[0], labStr, data[depIndex].split("~")[2]);
        }

        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }
    }

    // Delete Lab Method
    public static void deleteLab(int depIndex, int labIndex) throws IOException {
        String[] data = Global.readFromFile(file);
        String[] labArr = data[depIndex].split("~")[1].split("!");

        String tempLabArr = "";

        file.delete();
        File file = new File("data.txt");

        for (int i = 0; i < labArr.length; i++) {
            if (i == labIndex) {
                continue;
            }
            tempLabArr = tempLabArr + labArr[i] + "!";

        }

        data[depIndex] = String.join("~", data[depIndex].split("~")[0], tempLabArr,
                data[depIndex].split("~")[2]);

        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }
    }

    // Returns the "labs" i.e array-list as "Lab" array
    public static Lab[] assignLabs() {
        Lab temp[] = new Lab[labs.toArray().length];
        int i = 0;
        for (Object elementObject : labs.toArray()) {
            temp[i++] = (Lab) elementObject;
        }
        return temp;
    }

    // Return labs array list as an object array
    public static Object[] labsArray() {
        return labs.toArray();
    }

    // Setters
    public void setLabName(String labName) {
        this.labName = labName;
    }

    public void setLabAttendent(Employee labAttendent) {
        this.labAttendent = labAttendent;
    }

    public void setComputers(PCSystem[] computers) {
        this.computers = computers;
    }

    // Getters
    public String getLabName() {
        return labName;
    }

    public Employee getLabAttendent() {
        return labAttendent;
    }

    public PCSystem[] getComputers() {
        return computers;
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        Lab lab = (Lab) obj;
        if (this.labName == lab.labName) {
            return true;
        }
        return false;
    }

    // clone Method
    @Override
    protected Object clone() {
        Object temp;
        temp = new Lab(this.labName, this.labAttendent, this.computers);
        return temp;
    }

    // toString Method
    @Override
    public String toString() {
        String systemStr = "";
        for (PCSystem system : PCSystem.system) {
            systemStr = systemStr + system.toString();
        }
        return String.format("%s&%s&%s!", labName, labAttendent, systemStr);
    }

}