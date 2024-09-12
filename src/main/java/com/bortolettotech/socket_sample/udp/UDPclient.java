package udp;

import java.net.*;
import java.util.Scanner;

public class UDPclient {

    public static void main(String[] args) throws Exception {
        String ip = System.getenv().getOrDefault("IP", "localhost");
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "4567"));

        try (DatagramSocket socketClient = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(ip);

            Scanner scanner = new Scanner(System.in);
            String message;

            while (true) {
                System.out.println("Enter the text to be sent to the server (or 'cancel' to end): ");
                message = scanner.nextLine();

                if (message.equalsIgnoreCase("cancel")) {
                    break;
                }

                String headerMessage = "HEADER:";
                String messageWithHeader = headerMessage + message;

                byte[] messageBytes = messageWithHeader.getBytes();

                DatagramPacket datagramPacket = new DatagramPacket(messageBytes, messageBytes.length, address, port);

                socketClient.send(datagramPacket);
                System.out.println("Sent message → " + messageWithHeader);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}