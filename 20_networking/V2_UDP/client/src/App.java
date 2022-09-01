import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class App {
  private static final int BUFFER_SIZE = 100;
  private static final int PORT = 8080;
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    try (DatagramSocket socket = new DatagramSocket()) {
      InetAddress addr = InetAddress.getLocalHost();
      socket.setSoTimeout(3000);

      while (true) {
        System.out.print("Enter message: ");
        String message = sc.nextLine();
        if (message.equals("exit"))
          break;

        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, PORT);
        socket.send(packet);

        buffer = new byte[BUFFER_SIZE];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        // String received = new String(buffer));
        // String received = new String(buffer, 0, packet.getLength()));
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Text received: " + received);
      }
    } catch (SocketTimeoutException e) {
      System.out.println("SocketTimeoutException");
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}
