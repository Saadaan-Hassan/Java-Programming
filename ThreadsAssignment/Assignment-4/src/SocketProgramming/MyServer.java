package SocketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(7833);
            System.out.println("Waiting for Client....");
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            BufferedReader bfr = new BufferedReader(new FileReader("dataset/10001.txt"));
//            System.out.println(bfr.readLine());

//            File sendFile = new File("dataset/10001.txt");
//            OutputStream fos = new FileOutputStream(sendFile);

//            dos.writeLong(sendFile.length());
//            dos.flush();

            String str;
            String str2 = "";

            while (!str2.equals("stop")) {
                str = dis.readUTF();
                System.out.println("Client says: " + str);

                str2 = br.readLine();
                dos.writeUTF(str2);
                dos.flush();
            }
            br.close();
            dos.close();
            dis.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
