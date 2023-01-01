import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

public class Matcher2 implements Callable<Map<String, Integer>> {

    private final String fileName;
    private final Map<String, Integer> map;
    private static int i=1;
    Matcher2(String fileName, Map<String, Integer> map){
        this.fileName = fileName;
        this.map = map;
    }
    @Override
    public Map<String, Integer> call(){
        System.out.println(i++ +"- Reading File " + fileName + "...");
        return matcher(fileName, map);
    }


    private static Map<String,Integer> matcher(String  fileName, Map<String, Integer> map){
//        long startTime = System.nanoTime();
        File file = new File("dataset/" + fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            String [] words;
            while ((line = br.readLine()) != null){
//                line = line.replaceAll("[-.,';:?!`~@#$%^&*()_{}|<>\"]", "").replaceAll("\\[", "").replaceAll("]","").replaceAll("/", " ");
                words = line.split(" ");

                for (String word:
                     words) {
                    if (map.containsKey(word)){
                        int count = map.get(word);
                        map.put(word, count);
                    }else
                        map.put(word,1);
                }
            }

            br.close();
            fr.close();

        }catch (IOException ex){
            throw new RuntimeException();
        }
//        long totalTime = System.nanoTime() - startTime;
//        System.out.printf("Total execution time of Thread: %dms\n", totalTime / 1000000);
    return map;
    }
}
