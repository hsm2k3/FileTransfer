

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    public static final int PORT = 35103;
    public static final int BUFFER_SIZE = 626;

    @Override
    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("listening on port: " + serverSocket.getLocalPort());
            while(true)
            {
                Socket socket = serverSocket.accept();
                saveFile(socket);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void saveFile(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/home/alex/Success_testTransfer.txt");

        byte[] byteArray = new byte[1024];
        System.out.println("Reading file from server.");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int bytesRead;
        while((bytesRead = inputStream.read(byteArray)) != -1 )
        {
            bufferedOutputStream.write(byteArray);
        }

        bufferedOutputStream.close();
        System.out.println("Writing file complete.");
    }
    public static void main (String[] args) throws IOException {
        new Server().start();

    }
}
