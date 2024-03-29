import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void start () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            if(request.equals("stop")==false) {
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "Server received the request ...";
                out.println(raspuns);
                out.flush();
            }
            else{
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response = "Server Stopped";
                out.println(response);
                out.flush();
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

}
