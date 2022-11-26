import java.io.*;

public class Reader {
    public static String readFromFile(File file){
        String line = "";
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            line = br.readLine();

            br.close();
            fr.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return line;
    }

    public static String [] countNumbers(String [] data){
        int evenCount = 0;
        int oddCount = 0;

        for (String d :
                data) {
            int number = Integer.parseInt(d);

            if (number % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        String [] counts = new String[2];
        counts[0] = Integer.toString(oddCount);
        counts[1] = Integer.toString(evenCount);

        return counts;
    }
}
