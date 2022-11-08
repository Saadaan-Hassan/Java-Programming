//Array List Concepts
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> array = new ArrayList<String>();  //Declaring an Arraylist

        System.out.println(array);
        System.out.println(array.size());   //Printing size of Array list

        //Adding elements to Arraylist
        array.add("Saadaan Hassan");
        array.add("Arham Atique");
        array.add("Shafin-Uz-Zaman");
        array.add("Jawad Hassan");
        array.add("Zeeshan Zafar");
        array.add("Ammar Ahmad");
        array.add("Hamza Iftikhar");
        
        ArrayList<String> array2 = (ArrayList<String>)array.clone();

        System.out.println("=====================");
        System.out.println(array);
        System.out.println(array.size());
        System.out.println("=====================");
        
        displayString(array);
        System.out.println("=====================");
        
        array.remove(0);    //Removing an object at a specific index
        displayString(array);
        System.out.println(array.size());
        System.out.println("=====================");
        
        array.remove("Shafin-Uz-Zaman");    //Removing a specific object 
        displayString(array);
        System.out.println(array.size());
        System.out.println("=====================");
        
        array.removeAll(array); //Remove all the objects from the Arraylist
        displayString(array);
        System.out.println(array.size());
        System.out.println("=====================");

        System.out.println("Array list 2");
        System.out.println(array2);
        System.out.println(array2.size());
        System.out.println("=====================");
        
        array2.removeIf(n -> n.charAt(0) =='S');    //Remove objects which are satisfying certian conditions
        displayString(array2);
        System.out.println(array2.size());
        System.out.println("=====================");
        
        //Integer ArrayList
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        intArray.add(5);
        intArray.add(32);
        intArray.add(51);
        intArray.add(26);
        intArray.add(8);
        intArray.add(67);
        
        for (int element : intArray) {
            System.out.println(element);
        }
        System.out.println("=====================");
        
        Collections.sort(intArray);
        for (int element : intArray) {
            System.out.println(element);
        }
    }

    static void displayString(ArrayList<String> arr){
        for (String element : arr) {
            System.out.println(element);
        }
    }
}
