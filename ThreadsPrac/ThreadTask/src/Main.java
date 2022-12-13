import java.io.*;
import java.util.ArrayList;

public class Main implements Runnable {
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.run();
    }

    @Override
    public void run(){
        File file = new File("src/big.txt");
        ArrayList<Integer> lineOffset = new ArrayList<>();
        ArrayList<Integer> characterOffset = new ArrayList<>();
        int count = 0;
        String name = "James";

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            String [] words;

            int lineNumber = 0;
            int charnumber = 0;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[.,;:'!?()]", " ");
                words = line.split(" ");

                ++lineNumber;
                charnumber += line.length();
                for (String word:
                     words) {
                    if (word.toLowerCase().equalsIgnoreCase(name)){
//                        System.out.println(++count);
                        ++count;
                        lineOffset.add(lineNumber);
                        characterOffset.add(charnumber);
                    }
                }

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " occurs in file " + count + " times");
        System.out.println("--------------------------");
        for (int i = 0; i <count; i++) {
            System.out.println("Line Offset = " + lineOffset.get(i) + ", Character Offset = " + characterOffset.get(i));
        }
    }
}