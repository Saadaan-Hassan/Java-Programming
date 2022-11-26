public class Salesman extends Employee implements Payable{
    private double totalSale;
    private double commissionRate;
    private static int count;
    public Salesman(Date dateOfHiring, String name, double commissionRate, double totalSale) {
        super(dateOfHiring, name);
        this.totalSale = totalSale;
        this.commissionRate = commissionRate;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Salesman.count = count;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double earnings() {
        return totalSale * commissionRate;
    }

    @Override
    public double getPaymentAmount() {
        return totalSale * commissionRate;
    }

    @Override
    public String toString() {
        return String.format("%s %.1f %.2f", super.toString(), commissionRate, totalSale);
    }
}
