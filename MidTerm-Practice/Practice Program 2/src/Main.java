import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        File file = new File("temp.txt");
        Scanner sc = new Scanner(System.in);

        String [] arr = new String[10];


        arr[0] = "My name is Saadaan";
        arr[1] = sc.nextLine();
        arr[2] = sc.nextLine();

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != null){
//                File_IO.WriteToFile(file, arr[i]);
//            }
        File_IO.WriteToFile(file, arr);
        }



//        try{
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//
//            String str;
//
//            while ((str = br.readLine())!=null){
//                System.out.println(str);
//            }
//            br.close();
//            fr.close();
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }

    }
}