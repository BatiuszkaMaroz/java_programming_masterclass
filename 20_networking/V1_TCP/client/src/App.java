import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class App {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8080)) {
      /*
       * Set maximum timeout for waiting on InputStream.read() method.
       */
      socket.setSoTimeout(5000);

      BufferedReader input = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

      String message;
      String response;

      while (true) {
        System.out.print("Enter message: ");
        message = sc.nextLine();

        output.println(message);
        if (!message.equals("exit")) {
          response = input.readLine();
          System.out.println("Response: " + response + '\n');
        } else {
          break;
        }
      }
    } catch (SocketTimeoutException e) {
      System.out.println("Socket timed out");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
