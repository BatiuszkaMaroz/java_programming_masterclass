import java.io.IOException;
import java.net.ServerSocket;

public class App {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8080)) {
      while (true) {
        new Echoer(serverSocket.accept()).start();
        System.out.println("New client connected");
      }
    } catch (IOException e) {
      System.out.println("Server exception: " + e.getMessage());
    }
  }
}
