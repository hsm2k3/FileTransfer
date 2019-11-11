package server;

import java.io.*;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static final int MAX_PORT_NUMBER = 49151;
    public static final int MIN_PORT_NUMBER = 1100;
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
        FileOutputStream outputStream = new FileOutputStream("/home/alex/Documents/success_test.pdf");;

        byte[] byteArray = new byte[1024];
        try {
            System.out.println("Reading file from server...");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int bytesRead;
            while ((bytesRead = inputStream.read(byteArray)) != -1) {
                bufferedOutputStream.write(byteArray, 0, bytesRead);
            }

            bufferedOutputStream.close();
            System.out.println("Writing file complete...");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(inputStream != null)
                inputStream.close();
            if(outputStream != null)
                outputStream.close();
        }
    }

    public static boolean isPortAvailable()
    {
        if (PORT < MIN_PORT_NUMBER || PORT > MAX_PORT_NUMBER)
        {
            throw new IllegalArgumentException("Invalid start port: " + PORT);
        }

        ServerSocket serverSocket = null;
        DatagramSocket datagramSocket = null;
        try
        {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            datagramSocket = new DatagramSocket(PORT);
            datagramSocket.setReuseAddress(true);
            return true;
        }
        catch(Exception e)
        {
        }
        finally
        {
            if(datagramSocket != null)
            {
                try
                {
                    serverSocket.close();
                }
                catch (IOException e)
                {

                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        new Server().start();
    }
}