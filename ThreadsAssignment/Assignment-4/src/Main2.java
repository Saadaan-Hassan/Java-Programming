import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        File directory = new File("dataset");
        File[] files = directory.listFiles();
        long count=0;
        int i =1;
        long startTime = System.nanoTime();

        for (File file :
                files) {
            System.out.println(i++ +"- Reading File " + file);
//            File file = new File("dataset/" + fileName);
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;
                String[] words;
                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("[-.,';:?!`~@#$%^&*()_{}|<>\"]", "").replaceAll("\\[", "").replaceAll("]","").replaceAll("/", " ");
                    words = line.split(" ");

                    for (String word :
                            words) {
                        if (map.containsKey(word)) {
                            int wordCount = map.get(word);
                            count+=wordCount;
                            map.put(word, wordCount);
                        } else {
                            count+=1;
                            map.put(word, 1);
                        }
                    }
                }

                br.close();
                fr.close();

            } catch (IOException ex) {
                throw new RuntimeException();
            }
        }
        long totalTime = System.nanoTime() - startTime;
//        System.out.println(map);
        System.out.printf("Total words are: %d\n", count);
        System.out.printf("Total execution time of Thread: %dms\n", totalTime / 1000000);
    }
}
