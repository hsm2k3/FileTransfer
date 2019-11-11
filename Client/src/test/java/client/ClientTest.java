package client;

import app.App;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Client.class)
public class ClientTest {
    Client client;
    File file;
    App app;
    FileOutputStream fileOutputStream;
    Socket socket;
    byte[] byteArray;

    @Before
    public void initialize ()
    {
        client = mock(Client.class);
        file = mock(File.class);
        app = mock(App.class);
        fileOutputStream = mock(FileOutputStream.class);
        socket = mock(Socket.class);
        byteArray = new byte[8];
    }

    public void testSaveFile(Socket socket) throws Exception
    {
        socket.getInputStream();
        
    }
}
