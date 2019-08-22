import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String [] args ) throws IOException {
        byte bytes[] = new byte[2002];
        Socket socket = new Socket("localhost", 4333);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/media/alex/easystore/success_testTransfer.txt");
        inputStream.read(bytes, 0, bytes.length);
        fileOutputStream.write(bytes, 0, bytes.length);
    }
}
