import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matcher3 implements Runnable{

    private final File [] filesList;
    private final int numberOfThreads;
    private final int thread;
    private final int filesPerThread;
    private final int remainingFiles;

    private static int count = 1;

    public Matcher3(File[] filesList, int numberOfThreads, int thread, int filesPerThread, int remaingFiles) {
        this.filesList = filesList;
        this.numberOfThreads = numberOfThreads;
        this.thread = thread;
        this.filesPerThread = filesPerThread;
        this.remainingFiles = remaingFiles;
    }

    @Override
    public void run() {

        Aggregator.concatenate(matcher(filesList,numberOfThreads,thread,filesPerThread, remainingFiles));
    }

    private static Map<String,Integer> matcher(File[]  filesList, int numberOfThreads, int thread, int filesPerThread, int remainingFiles){

        List<File> inFiles = new ArrayList<>();
        for (int i = thread * filesPerThread; i < (thread + 1) * filesPerThread; i++)
            inFiles.add(filesList[i]);
        if(thread == numberOfThreads - 1 && remainingFiles > 0)
            for (int j = filesList.length-remainingFiles; j < filesList.length; j++)
                inFiles.add(filesList[j]);

        Map<String, Integer> map = new HashMap<>();
        for (File file: inFiles) {
            System.out.println(count++ +"- Reading file: " + file + " in " + Thread.currentThread().getName());

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
                            int count = map.get(word);
                            map.put(word, count);
                        } else
                            map.put(word, 1);
                    }
                }

                br.close();
                fr.close();

            } catch (IOException ex) {
                throw new RuntimeException();
            }

        }
        return map;
    }
}
