import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClientMain {
    private static DataInputStream dataInputStream = null;
    public static void main(String[] args) {

        try {

            Socket s = new Socket("localhost", 7546);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Connection Successful");
            dataInputStream = new DataInputStream(s.getInputStream());

            System.out.println("Receiving Files from server...");
            File directory = new File("dataset2");
            directory.mkdirs();

            int numberOfFiles = dataInputStream.readInt();

            for (int j = 0; j < numberOfFiles; j++) {
                receiveFile(directory.getName() + "/test" + j + ".txt");
            }


            System.out.println("Files Received Successfully.");

            File [] files = directory.listFiles();
            assert files != null;
            File [] clientFiles = new File[files.length];

            for (int k = 0; k < files.length; k++) {
                    clientFiles[k] = (files[k]);
                }

            long startTime = System.nanoTime();

            int nbThreads = Runtime.getRuntime().availableProcessors();

            int filesPerThread = clientFiles.length / nbThreads;
            int remainingFiles = clientFiles.length % nbThreads;

            ExecutorService executorService = Executors.newFixedThreadPool(nbThreads);
            for (int j = 0; j < nbThreads; j++) {
                executorService.execute(new Matcher(clientFiles, nbThreads, j, filesPerThread, remainingFiles));
            }

            executorService.shutdown();

            while (true) {
                try {
                    if (executorService.awaitTermination(2, TimeUnit.MINUTES)) break;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;


            System.out.println("\nTotal time in execution of main:" + timeElapsed / 1000000 + "ms");
            directory.delete();
            oos.writeObject(Aggregator.getConcatMap());
            dataInputStream.close();
            oos.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void receiveFile(String fileName){
        int bytes;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);

            long size = dataInputStream.readLong(); // read file size
            byte[] buffer = new byte[4 * 1024];
            while (size > 0 && (bytes = dataInputStream.read(buffer, 0,(int) Math.min(buffer.length, size)))!= -1) {
                // Here we write the file using write method
                fileOutputStream.write(buffer, 0, bytes);
                size -= bytes; // read upto file size
            }
            // Here we received file
            System.out.println("Received.......");
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
