import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientJava {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 4444);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello from Java client");
        
        out.close();
        socket.close();
    }
    
}
