package tcp;

import java.io.*;
import java.net.*;

public class TCPserver {

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "1234"));

        ServerSocket server = new ServerSocket(port);
        System.out.println("System waiting for connections....");
        Socket connection = server.accept();
        System.out.println("Client connected " + connection);

        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
        DataOutputStream outflow = new DataOutputStream(connection.getOutputStream());

        String message;
        while (true) {
            try {
                message = inputStream.readUTF();
                System.out.println("Client (" + connection.getPort() + ") → " + message);

                if ("quit".equalsIgnoreCase(message)) {
                    break;
                }

                outflow.writeUTF(message);
                outflow.flush();
            } catch (EOFException e) {
                System.err.println("Connection closed for some reason.");
                break;
            }
        }

        inputStream.close();
        outflow.close();
        connection.close();
        server.close();
    }
}