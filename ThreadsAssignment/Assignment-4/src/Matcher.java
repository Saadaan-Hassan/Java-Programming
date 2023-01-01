import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Matcher extends Thread{
    public static void matcher(File file){

    }

    @Override
    public void start() {
        long startTime = System.nanoTime();


        //Creating a File object for directory
        File directoryPath = new File("dataset");
        //List of all files and directories
        String[] files = directoryPath.list();

        Map<String, Integer> map = new HashMap<>();

        assert files != null;
        for (String f : files) {
            File file = new File("dataset/" + f);


            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;
                String[] words;


                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("[\"_&$#@!~`^*+=<>.,;:'!?()-]", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("/", " ");
                    words = line.split(" ");

                    for (String word :
                            words) {
                        if (map.containsKey(word)) {
                            int count = map.get(word);
                            map.put(word, count + 1);
                        } else {
                            map.put(word, 1);
                        }
                    }

                }

                br.close();
                fr.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            for (Map.Entry<String, Integer> entry :
                    map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }


        System.out.println("--------------------------");
        System.out.println(map);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.printf("Total execution time of Thread: %dms\n", totalTime / 1000000);
    }
}
