public class HourlyEmployee extends Employee {
    private double numberOfHoursWorked;
    private double hourlyRate;

    public HourlyEmployee(int id, String name, double numberOfHoursWorked, double hourlyRate) {
        super(id, name);
        this.numberOfHoursWorked = numberOfHoursWorked;
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double calculatePay() {
        return this.hourlyRate * this.numberOfHoursWorked;
    }

    @Override
    public String toString() {
        return String.format("H %s %.2f %.2f", super.toString(), numberOfHoursWorked, hourlyRate);
    }
}
