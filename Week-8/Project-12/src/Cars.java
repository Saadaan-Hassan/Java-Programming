public class Cars{
    private String name;
    private String carNumber;
    private static int count = 0;

    public Cars(String name, String carNumber) {
        this.name = name;
        this.carNumber = carNumber;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", name, carNumber);
    } 


    
}
