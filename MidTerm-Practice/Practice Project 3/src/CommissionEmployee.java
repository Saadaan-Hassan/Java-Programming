public class CommissionEmployee extends Employee {
    private double amountOfSales;
    private double commissionRate;

    public CommissionEmployee(int id, String name, double amountOfSales, double commissionRate) {
        super(id, name);
        this.amountOfSales = amountOfSales;
        this.commissionRate = commissionRate;
    }


    @Override
    public double calculatePay() {
        return amountOfSales * commissionRate;
    }

    @Override
    public String toString(){
        return  String.format("C %s %.2f %.2f", super.toString(), amountOfSales, commissionRate);
    }

}
