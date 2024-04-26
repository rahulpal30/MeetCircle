package meetcircle1;

import java.io.*;
import java.net.*;

public class MeetCircleClient {
    
    public static void main(String[] args) {
        String hostName = "localhost"; // Server hostname
        int portNumber = 9999; // Server port
        
        try {
            Socket socket = new Socket(hostName, portNumber);
            System.out.println("Connected to server.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            Thread receiveThread = new Thread(new ReceiveHandler(in));
            receiveThread.start();
            
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
            
            out.close();
            in.close();
            stdIn.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Error: Unknown host: " + hostName);
        } catch (IOException e) {
            System.err.println("Error: Could not connect to server.");
        }
    }
    
    static class ReceiveHandler implements Runnable {
        private BufferedReader in;
        
        public ReceiveHandler(BufferedReader in) {
            this.in = in;
        }
        
        @Override
        public void run() {
            try {
                String serverResponse;
                // Receive and display messages from the server
                while ((serverResponse = in.readLine()) != null) {
                    System.out.println("Server: " + serverResponse);
                }
            } catch (IOException e) {
                System.err.println("Error receiving message from server: " + e.getMessage());
            }
        }
    }
}
