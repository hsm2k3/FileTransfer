package Client;

import java.io.*;
import java.net.Socket;


public class Client {
    public static final String fileName = "/home/alex/Documents/test.txt";
    public static final int PORT = 3332;
    public static void main(String[] args) throws Exception {


        try {
            File file = new File(fileName);
            Socket socket = new Socket("localhost", PORT);
            byte[] byteArray = new byte[(int) file.length()];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(byteArray, 0, byteArray.length);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(byteArray, 0, byteArray.length);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
        }

    }
}