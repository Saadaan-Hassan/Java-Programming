import java.io.*;

public class Global {
    // Write in file
    static void writeToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.newLine();
        bw.close();

    }

    // Read from file
    static String[] readFromFile(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String data[] = new String[1000];
        String temp = "";
        int counter = 0;
        while ((temp = br.readLine()) != null) {
            data[counter++] = temp;
        }
        br.close();
        return data;
    }

    
}
