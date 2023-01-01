package SocketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "";
            String str2 = "";

            while (!str2.equals("stop")) {
                str = dis.readUTF();
                System.out.println("Client says: " + str);
                str2 = br.readLine();
                dos.writeUTF(str2);
                dos.flush();
            }
//            br.close();
//            dos.close();
            dis.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
