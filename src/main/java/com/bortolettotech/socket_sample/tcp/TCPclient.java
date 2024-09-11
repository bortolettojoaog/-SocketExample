package tcp;

import java.io.*;
import java.net.*;

public class TCPclient {

    public static void main(String[] args) {

        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "1234"));
        String ip = System.getenv().getOrDefault("IP", "127.0.0.1");

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        try {
            Socket connection = new Socket(ip, port);
            System.out.println("Connected (" + connection + ")");

            DataOutputStream outflow = new DataOutputStream(connection.getOutputStream());
            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(connection.getInputStream()));

            String sentence;
            while (true) {
                System.out.println("Enter the text to be sent to the server (or 'cancel' to end): ");
                sentence = inFromUser.readLine();

                outflow.writeUTF(sentence);
                outflow.flush();

                if ("cancel".equalsIgnoreCase(sentence)) {
                    break;
                }

                try {
                    String message = inputStream.readUTF();
                    System.out.println("Sent message → " + message);
                } catch (EOFException e) {
                    System.err.println("Connection closed for some reason.");
                    break;
                }
            }

            outflow.close();
            inputStream.close();
            connection.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}