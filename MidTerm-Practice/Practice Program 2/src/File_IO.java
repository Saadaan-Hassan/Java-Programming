import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_IO {
    public static void WriteToFile(File file, String [] text){
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < text.length ; i++) {
                if (text[i] != null)
                bw.write(text[i]);
                bw.newLine();
            }

            bw.close();
            fw.close();


        } catch (IOException e) {
            System.out.println("File not existed");
        }
    }


}
