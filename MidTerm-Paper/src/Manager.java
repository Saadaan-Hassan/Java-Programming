public class Manager extends Employee implements Payable{
    private double fixedSalary;
    private static int count;
    public Manager(Date dateOfHiring, String name, double fixedSalary) {
        super(dateOfHiring, name);
        this.fixedSalary = fixedSalary;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Manager.count = count;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double earnings() {
        return fixedSalary;
    }

    @Override
    public double getPaymentAmount() {
        return fixedSalary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), fixedSalary);
    }
}
