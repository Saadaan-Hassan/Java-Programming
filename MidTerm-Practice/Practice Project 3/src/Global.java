import java.io.*;
import java.util.ArrayList;

public class Global {

    public static void WriteToFile(File file, String text){
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(text);
            bw.newLine();

            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static ArrayList<String> ReadFromFile(File file) {
        ArrayList<String> data= new ArrayList<String>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String temp;

            while((temp = br.readLine())!= null) {
                data.add(temp);

            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
}
