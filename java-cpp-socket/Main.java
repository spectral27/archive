import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        serverSocket = new ServerSocket(4444);

        clientSocket = serverSocket.accept();

        BufferedWriter wr;
        wr = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        wr.write("My Java Messages!");
        wr.flush(); // flushes the stream

        String inputLine;
        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        serverSocket.close();
        clientSocket.close();
    }

}
