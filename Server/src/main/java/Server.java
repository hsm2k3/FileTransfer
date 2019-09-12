import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static final int PORT = 3332;
    public static final int BUFFER_SIZE = 626;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket s = serverSocket.accept();
                saveFile(s);
            }
        } catch (Exception e) {
        }
    }

    private void saveFile(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/home/alex/Documents/test.txt");;

        byte[] byteArray = new byte[1024];
        System.out.println("Reading file from server...");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int bytesRead;
        while ((bytesRead = inputStream.read(byteArray)) != -1) {
            bufferedOutputStream.write(byteArray);
        }

        bufferedOutputStream.close();
        System.out.println("Writing file complete...");

    }

    public static void main(String[] args) {
        new Server().start();
    }
}