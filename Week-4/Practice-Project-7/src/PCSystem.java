import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PCSystem {
    private String assestID;
    private String companyName;
    private String cpuSerialNo;
    private int ramSizeMb;
    private int hardDiskGb;
    private boolean gpu;

    static File file = new File("data.txt");

    static ArrayList<PCSystem> system = new ArrayList<>(); // Declaring Array list for Systems
    static ArrayList<String> inputs; // Declaring an inputs array
    // Initialzing 'ids' array for storing dummy ids.
    static String ids[] = { "CSC003", "CSC007", "CSC012", "CSC089", "CSC021", "CSC006", "CSC001", "CSC019", "CSC001",
            "CSC054" };
    // Initialzing 'serialNumber' array for storing dummy serial numbers.
    static String serailNumber[] = { "CS10023", "CS10034", "CS34322", "CS40324", "CS93204", "CS12432", "EE43234",
            "PY32439", "SE21424", "PH32480" };

    // Initialzing 'company' array for storing dummy company names.
    static String company[] = { "HP", "Dell", "Lenovo", "Asus" };

    // Initialzing 'size' array for storing dummy sizes for ram and hard disk.
    static int size[] = { 4000, 2000, 8000, 32000, 16000 };

    // Initialzing 'option' array for storing boolean values.
    static boolean option[] = { true, false };

    static Scanner sc = new Scanner(System.in);

    public PCSystem(String assestID, String companyName, String cpuSerialNo, int ramSizeMb, int hardDiskGb,
            boolean gpu) {
        this.assestID = assestID;
        this.companyName = companyName;
        this.cpuSerialNo = cpuSerialNo;
        this.ramSizeMb = ramSizeMb;
        this.hardDiskGb = hardDiskGb;
        this.gpu = gpu;
    }

    // Copy Constructor
    public PCSystem(PCSystem pc) {
        this.assestID = pc.assestID;
        this.companyName = pc.companyName;
        this.cpuSerialNo = pc.cpuSerialNo;
        this.ramSizeMb = pc.ramSizeMb;
        this.hardDiskGb = pc.hardDiskGb;
        this.gpu = pc.gpu;
    }

    // Populating PCSystem objects and storing them into an array.
    static void makeSystem() {
        for (int i = 0; i < 10; i++) {
            PCSystem sys = new PCSystem(ids[i], company[i % company.length], serailNumber[i], size[i % size.length],
                    size[i % size.length] / 10, option[i % option.length]);

            system.add(sys);
        }
    }

    // Display the Systems
    static void displaySystems(int deptNumber, int labNumber) throws IOException {

        String[] data = Global.readFromFile(file);

        int j = 0;
        String[] splitStr;

        String requiredDept = data[deptNumber];
        if (requiredDept != null) {
            splitStr = requiredDept.split("~")[1].split("!")[labNumber].split("#");
            for (int i = 0; i < splitStr.length; i++) {

                // assestID, companyName, cpuSerialNo, ramSizeMb, hardDiskGb, gpu
                String assestID = splitStr[i].split("`")[0];
                String companyName = splitStr[i].split("`")[1];
                String cpuSerialNo = splitStr[i].split("`")[2];
                String ramSizeMb = splitStr[i].split("`")[3];
                String hardDiskGb = splitStr[i].split("`")[4];
                String gpu = splitStr[i].split("`")[5];

                System.out.printf("System-%d Information:\n", j + 1);
                System.out.println("------------");
                System.out.printf(
                        "Asset ID: %s\nCompany Name: %s\nCPU Serial No.: %s\nRam Size in Mb: %s\nHard Disk in GB: %s\nGPU: %s\n\n",
                        assestID, companyName, cpuSerialNo, ramSizeMb, hardDiskGb, gpu);
                j++;
            }
        }
    }

    // Add System Method
    static void addSystem(int deptIndex, int labIndex) throws IOException {
        inputs = new ArrayList<>();

        System.out.print("Enter Assest ID: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter Company Name: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter CPU Serial No: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter Ram Size in Mb: ");
        inputs.add(sc.nextLine());

        System.out.print("Enter Hard Disk in Gb: ");
        inputs.add(sc.nextLine());

        System.out.print("Is gpu present?(true/false): ");
        inputs.add(sc.nextLine());

        PCSystem newSystem = new PCSystem(inputs.get(0), inputs.get(1), inputs.get(2),
                Integer.parseInt(inputs.get(3)), Integer.parseInt(inputs.get(4)),
                Boolean.parseBoolean(inputs.get(5)));

        system.add(newSystem);

        String data[] = Global.readFromFile(file);

        file.delete();

        File file = new File("data.txt");
        String labArr[] = data[deptIndex].split("~")[1].split("!");
        String systemsArr[] = labArr[labIndex].split("#");
        String labStr = "";
        String systemStr = "";

        for (int i = 0; i < systemsArr.length; i++) {
            systemStr = systemStr + systemsArr[i] + "#";
        }

        systemStr = systemStr + newSystem.toString() + "!";

        labArr[labIndex] = String.join("&", labArr[labIndex].split("&")[0], labArr[labIndex].split("&")[1], systemStr);

        for (int i = 0; i < labArr.length; i++) {
            labStr = labStr + labArr[i] + "!";
        }

        data[deptIndex] = String.join("~", data[deptIndex].split("~")[0], labStr, data[deptIndex].split("~")[2]);

        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }
    }

    // Delete PCSystem Method
    public static void deleteSystem(int deptIndex, int labIndex, int systemIndex) throws IOException {
        String[] data = Global.readFromFile(file);

        String labArr[] = data[deptIndex].split("~")[1].split("!");
        String systemsArr[] = labArr[labIndex].split("#");

        String labStr = "";
        String tempSystemArr = "";

        file.delete();
        File file = new File("data.txt");

        for (int i = 0; i < systemsArr.length; i++) {
            if (i == systemIndex) {
                continue;
            }
            tempSystemArr = tempSystemArr + systemsArr[i] + "#";
        }

        labArr[labIndex] = String.join("&", labArr[labIndex].split("&")[0], labArr[labIndex].split("&")[1], tempSystemArr);

        for (int i = 0; i < labArr.length; i++) {
            labStr = labStr + labArr[i] + "!";
        }

        data[deptIndex] = String.join("~", data[deptIndex].split("~")[0], labStr, data[deptIndex].split("~")[2]);

        for (int j = 0; j < data.length; j++) {
            if (data[j] != null)
                Global.writeToFile(file, data[j]);
        }
    }

    // Returns the "systems" i.e array-list as "System" array
    static PCSystem[] assignSystems() {
        PCSystem systems[] = new PCSystem[system.toArray().length];

        int i = 0;
        for (Object pcSystem : system.toArray()) {
            systems[i++] = (PCSystem) pcSystem;
        }
        return systems;
    }

    // Setters
    public void setAssestID(String assestID) {
        this.assestID = assestID;
    }

    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCpuSerialNo(String cpuSerialNo) {
        this.cpuSerialNo = cpuSerialNo;
    }

    public void setRamSizeMb(int ramSizeMb) {
        this.ramSizeMb = ramSizeMb;
    }

    public void setHardDiskGb(int hardDiskGb) {
        this.hardDiskGb = hardDiskGb;
    }

    public void setGpu(boolean gpu) {
        this.gpu = gpu;
    }

    // Getters
    public String getAssestID() {
        return assestID;
    }

    public String getcompanyName() {
        return companyName;
    }

    public String getCpuSerialNo() {
        return cpuSerialNo;
    }

    public int getRamSizeMb() {
        return ramSizeMb;
    }

    public int getHardDiskGb() {
        return hardDiskGb;
    }

    public boolean isGpu() {
        return gpu;
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        PCSystem pc = (PCSystem) obj;

        boolean equal = false;
        if (this.assestID == pc.assestID)
            equal = true;
        return equal;
    }

    // clone method
    @Override
    protected Object clone() {
        Object temp;

        temp = new PCSystem(this.assestID, this.companyName, this.cpuSerialNo, this.ramSizeMb, this.hardDiskGb,
                this.gpu);

        return temp;
    }

    // toString Method
    @Override
    public String toString() {
        // return String.format(
        // "Assest ID: %s, Company Name: %s, Cpu Serial No: %s, Ram Size in Mbs: %d,
        // Hard Disk in Gb: %d, GPU Present: %b\n",
        // assestID, companyName, cpuSerialNo, ramSizeMb, hardDiskGb, gpu);
        return String.format("%s`%s`%s`%d`%d`%b#", assestID, companyName, cpuSerialNo, ramSizeMb, hardDiskGb, gpu);
    }

}