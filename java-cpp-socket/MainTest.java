import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainTest {
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        boolean closeServer = false;

        while (true) {
            if (closeServer) {
                break;
            }

            System.out.println("Accepting messages...");
            
            Socket socket = server.accept();

            String inputLine;
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("exit")) {
                    closeServer = true;
                    socket.close();
                    break;
                }

                System.out.println(inputLine);
            }
    
        }

        server.close();


    }

}
