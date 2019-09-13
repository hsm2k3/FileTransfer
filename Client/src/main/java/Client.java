import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String [] args ){

        String fileName = "/media/alex/easystore/testTransfer.txt";
        try
        {
            File file = new File(fileName);
            Socket socket = new Socket("localhost", 35103);
            byte[] byteArray = new byte[(int)file.length()];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(byteArray, 0, byteArray.length);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(byteArray, 0, byteArray.length);
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

