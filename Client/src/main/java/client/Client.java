package client;

import java.io.*;

import app.App;
import java.net.Socket;


public class Client {
    public static final String fileName = "/home/alex/Documents/Calculus, 10th Ed - Larson, Edwards.pdf";
    public static final int PORT = 3332;
    public static void main(String[] args) throws Exception {
        new App();
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