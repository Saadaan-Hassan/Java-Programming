package SocketProgramming;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            String address = "192.168.18.4";
            Socket s = new Socket(address, 3333);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str ="";
            String str2 ="";

            while (!str.equals("stop")) {
                str = br.readLine();
                dos.writeUTF(str);
                dos.flush();

                str2 = dis.readUTF();
                System.out.println("Server says: " + str2);

            }
//            br.close();
            dos.close();
//            dis.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
