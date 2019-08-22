import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4333);
        Socket socket = serverSocket.accept();
        FileInputStream fileInputStream = new FileInputStream("/media/alex/easystore/testTransfer.txt");
        byte bytes [] = new byte[2002];
        fileInputStream.read(bytes, 0 ,bytes.length);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);

    }
}
