import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        File directory = new File("dataset");
        File [] files = directory.listFiles();

        long startTime = System.nanoTime();

        int nbThreads = Runtime.getRuntime().availableProcessors();
//        int nbThreads = 4;
//        Thread [] threads = new Thread[nbThreads];

        assert files != null;
        int filesPerThread = files.length/nbThreads;
        int remainingFiles = files.length%nbThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(nbThreads);
        for (int j = 0; j < nbThreads; j++) {
            int thread = j;
            executorService.execute(new Matcher3(files, nbThreads,thread,filesPerThread,remainingFiles));
//            threads[j] = new Thread(new Matcher3(files, nbThreads,thread,filesPerThread,remainingFiles));
        }

        executorService.shutdown();
//        for (Thread t1 :
//                threads) {
//            t1.start();
//        }
//        for (Thread t2 :
//                threads) {
//            t2.join();
//        }

//        while (!executorService.isTerminated()){
//
//        }

        while(true) {
            try {
                if (executorService.awaitTermination(2, TimeUnit.MINUTES)) break;
                // it will wait till all the threads have finished or Max 5 mins
                // before going back to main thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Aggregator.display();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("\nTotal time in execution of main:" + timeElapsed/1000000 + "ms");

    }
}
