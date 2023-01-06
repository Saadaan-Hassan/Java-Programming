package SocketProgramming;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
//            String address = "192.168.18.4";
//            String address = "192.168.132.239";
//            String address = "192.168.132.202";
//            String address = "192.168.11.109";
//            String address = "10.135.88.128";
//            String address = "192.168.1.104";
            String address = "localhost";

            Socket s = new Socket(address, 7833);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str ="";
            String str2;

            dos.writeUTF("Connection Successful.");
            System.out.println("Connection Successful.");
            while (!str.equals("stop")) {
                str = br.readLine();
                dos.writeUTF(str);
                dos.flush();

                str2 = dis.readUTF();
                System.out.println("Server says: " + str2);

            }
            br.close();
            dos.close();
            dis.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
