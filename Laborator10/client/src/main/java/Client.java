import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static  void main(String[] args) throws IOException {

        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        while (true) {
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {

                // Send a request to the server
                Scanner console = new Scanner(System.in);
                String request = console.next();
                out.println(request);
                if (request.equals("esc")) {
                    System.exit(0);
                }
                // Wait the response from the server
                String response = in.readLine();

                System.out.println(response);

            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



