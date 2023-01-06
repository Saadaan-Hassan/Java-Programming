import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadingWithoutThreads {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        File directory = new File("dataset");
        File[] files = directory.listFiles();

        int i =1;
        long startTime = System.nanoTime();

        assert files != null;
        for (File file :
                files) {
            System.out.println(i++ +"- Reading File " + file);
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;
                String[] words;
                while ((line = br.readLine()) != null) {

                    line = line.replaceAll("[^a-zA-Z0-9]", " ");
                    words = line.split(" ");

                    for (String word :
                            words) {
                        if (map.containsKey(word)) {
                            int wordCount = map.get(word);
                            map.put(word, wordCount+1);
                        } else {
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

//        for (Map.Entry<String, Integer> entry :
//                map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        FileHandling.writeToFile("Outputs/WithoutThread.txt", map);

        long totalTime = System.nanoTime() - startTime;
        System.out.printf("Total execution time of Main: %dms\n", totalTime / 1000000);
    }
}
