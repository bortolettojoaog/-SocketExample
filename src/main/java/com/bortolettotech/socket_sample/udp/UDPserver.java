package udp;

import java.net.*;

public class UDPserver {

    public static void main(String[] args) throws Exception {
        int serverPort = Integer.parseInt(System.getenv().getOrDefault("PORT", "4567"));

        System.out.println("System waiting for connections....");

        try {
            DatagramSocket server = new DatagramSocket(serverPort);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket receivedDatagram = new DatagramPacket(buffer, buffer.length);

                server.receive(receivedDatagram);

                InetAddress clientIP = receivedDatagram.getAddress();
                int clientPort = receivedDatagram.getPort();

                String message = new String(receivedDatagram.getData(), 0, receivedDatagram.getLength());
                System.out.println("Received from " + clientIP + ":" + clientPort + " → " + message);


                String response = "Received Message";
                byte[] responseData = response.getBytes();
                DatagramPacket responsePackage = new DatagramPacket(responseData, responseData.length, clientIP, clientPort);
                server.send(responsePackage);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}