import java.util.ArrayList;

public class CarsTest {
    public static void main(String[] args) {
        Cars car1 = new Cars("Mercedes", "BDV234");
        System.out.println(car1);

        
        ArrayList<Cars> carArray = new ArrayList<>();
        carArray.add(car1);
        carArray.add(new Cars("Oddi", "BNG832"));
        carArray.add(new Cars("Civic", "YIO032"));
        
    }
}
