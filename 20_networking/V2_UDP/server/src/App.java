import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class App {
  private static final int BUFFER_SIZE = 100;
  private static final int PORT = 8080;

  public static void main(String[] args) {
    try (DatagramSocket socket = new DatagramSocket(PORT)) {
      while (true) {
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Message received: " + received);

        /*
         * Sending response in UDP is not always good. UDP is connectionless.
         * It's better to have one Sender and one Listener sockets or smth ???
         */

        InetAddress addr = packet.getAddress();
        int port = packet.getPort();
        String message = "echo-" + received;
        buffer = message.getBytes();

        packet = new DatagramPacket(buffer, buffer.length, addr, port);
        socket.send(packet);
      }
    } catch (SocketException e) {
      System.out.println("SocketException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}
