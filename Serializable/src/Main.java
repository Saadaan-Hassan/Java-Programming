import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Saadaan", 19);
        Person p2 = new Person("Hamza", 21);
        Person p3 = new Person("Arham", 20);

        Person [] personArray = new Person[4];
        personArray[0] = new Person("Jawad", 20);
        personArray[1] = new Person("Ammar", 21);
        personArray[2] = new Person("Zeeshan", 20);
        personArray[3] = new Person("Shafin", 19);


        String fileName = "file.ser";
        File file = new File(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(personArray);


            oos.close();
            fos.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        //Deserialization
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person pr1 = (Person) ois.readObject();
            Person pr2 = (Person) ois.readObject();
            Person pr3 = (Person) ois.readObject();
            Person [] people = (Person[]) ois.readObject();

            System.out.println(pr1);
            System.out.println(pr2);
            System.out.println(pr3);

            System.out.println("============================");
            for (Person person: people)
                System.out.println(person);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}