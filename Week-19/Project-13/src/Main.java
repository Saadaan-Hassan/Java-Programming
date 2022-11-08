import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Mobiles> mobiles = new ArrayList<Mobiles>();
        mobiles.add(new Mobiles("Galaxy Z Fold 4", "Samsung", 16, 8, "Android 11"));
        mobiles.add(new Mobiles("Hot 11 Play", "OPPO", 8, 5, "Android 10"));
        mobiles.add(new Mobiles("Infinix 9", "Infinix", 12, 6, "Android 12"));
        mobiles.add(new Mobiles("A32 S", "Samsung", 8, 4, "Android 13"));
        mobiles.add(new Mobiles("Huawei Y9", "Huawei", 32, 12, "Android 9"));

        //Displaying Array List with out sorting
        dispaly(mobiles);
        System.out.println("========================");

        Collections.sort(mobiles);  //Sorting List by name
        //Displaying List after sorting
        dispaly(mobiles);
        System.out.println("========================");

        Collections.reverse(mobiles); //Sorting List in reverse order
        dispaly(mobiles);
        System.out.println("========================");

        mobiles.sort(mobiles.get(0));   //Sorting list By Ram
        dispaly(mobiles);
        System.out.println("========================");

        mobiles.sort(new CompareByCompany());   //Sorting list by Company
        dispaly(mobiles);
        System.out.println("========================");

        String name = mobiles.get(2).getCompany();  //Getting company name of object at index 2
        System.out.println(name);
        mobiles.get(2).setCompany("Vivo");  //Replacing company name of object at index 2

        dispaly(mobiles);
    }

    //Display Function
    static void dispaly(ArrayList<Mobiles> arr){
        for (Mobiles m: arr){
            System.out.println(m);
        }
    }
}