/*
 * Name: Syed Mohammad Saadaan Hassan
 * Reg No.: SP22-BCS-003
 * Section: C
 */
public class Driver {

    static Person LIST[] = new Person[10];
    
    public static void main(String[] args){
        
        final String FIRST_NAME[] = {"Saadaan", "Ali", "Jawad", "Kabeer"};
        final String LAST_NAME[] = {"Hassan", "Ahmed", "Ali"};
        final Date DOB[] = new Date[5];

         for (int i = 0; i < DOB.length; i++) {
             DOB[i] = new Date(i,i+4,2000+(i*2));
         }
         
         for (int i = 0; i < LIST.length; i++) {

            LIST[i] = new Person(FIRST_NAME[i%FIRST_NAME.length], LAST_NAME[i%LAST_NAME.length], DOB[i % DOB.length]);
        }

        displayList(LIST);

        System.out.println("Total Persons: " + countPerson(LIST));
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
