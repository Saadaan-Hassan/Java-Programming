/*
 * Name: Syed Mohammad Saadaan Hassan
 * Reg No.: SP22-BCS-003
 * Section: C
 */
public class Driver2 {

    public static Person list[] = new Person[10];
    
    public static void main(String[] args){

        list[0] = new Person("Ali", "Ahmed", new Date(12, 03, 2004));
        list[1] = new Person("Hamza", "Mehmood", new Date(2, 5, 2001));
        list[2] = new Person("Zuraiz", "Ali", new Date(13, 6, 2000));
        list[3] = new Person("Arham", "Atique", new Date(12, 9, 2008));
        list[4] = new Person("Zeeshan", "Zafar", new Date(1, 2, 2010));
        list[5] = new Person("Ammar", "Ahmad", new Date(18, 1, 2002));
        list[6] = new Person("Jawad", "Hassan", new Date(22, 7, 2000));


        displayList(list);

        System.out.println("Total Persons: " + countPerson(list));
    }

    public static void displayList(Person list[]) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println(list[i]);
            }
        }
    }
    
     public static int countPerson(Person list[]) {
        int counter=0;
        for (int i = 0; i < list.length; i++) {
            if(list[i]!=null)
                counter++;
        }

        return counter;
            
    }
}
