import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerMain {
    private static DataOutputStream dataOutputStream = null;
    public static void main(String[] args) {
        File directory = new File("dataset");
        File[] files = directory.listFiles();
        assert files != null;
        File[] serverFiles = new File[(int) Math.ceil(files.length / 2)];

        for (int i = 0; i < files.length / 2; i++) {
            serverFiles[i] = (files[i]);
        }

        try {
            ServerSocket ss = new ServerSocket(7546);

            System.out.println("Waiting for Client...");
            Socket s = ss.accept();
            System.out.println("Connection Successful");
            System.out.println("Sending Files to Client...");

            dataOutputStream = new DataOutputStream(s.getOutputStream());

            dataOutputStream.writeInt(files.length/2);
            dataOutputStream.flush();

            for (int i = 0; i < files.length; i++) {
                if (i < files.length/2){
                }else {
//                    System.out.println(i + "- Sending File: " + files[i].getAbsolutePath());
                    sendFile(files[i].getAbsolutePath());
                }
            }
            System.out.println("Files Send Successfully.");


            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());


            long startTime = System.nanoTime();

            int nbThreads = Runtime.getRuntime().availableProcessors();

            int filesPerThread = serverFiles.length / nbThreads;
            int remainingFiles = serverFiles.length % nbThreads;

            ExecutorService executorService = Executors.newFixedThreadPool(nbThreads);
            for (int j = 0; j < nbThreads; j++) {
                executorService.execute(new Matcher(serverFiles, nbThreads, j, filesPerThread, remainingFiles));
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

            Map<String, Integer> receiveObject = (Map<String, Integer>) ois.readObject();

            Aggregator.collectMaps(receiveObject);
            Aggregator.writeInFile("Outputs/UsingServerClient.txt");
            System.out.println("\nTotal time in execution of main:" + timeElapsed / 1000000 + "ms");

            dataOutputStream.close();
            s.close();
            ss.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        private static void sendFile(String path){
            int bytes;
            // Open the File where he located in your pc
            File file = new File(path);
            FileInputStream fileInputStream
                    = null;
            try {
                fileInputStream = new FileInputStream(file);


            // Here we send the File to Server
            dataOutputStream.writeLong(file.length());
            // Here we  break file into chunks
            byte[] buffer = new byte[4 * 1024];
            while ((bytes = fileInputStream.read(buffer))
                    != -1) {
                // Send the file to Server Socket
                dataOutputStream.write(buffer, 0, bytes);
                dataOutputStream.flush();
            }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    assert fileInputStream != null;
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            // close the file here
        }
}
