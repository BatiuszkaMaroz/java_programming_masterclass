import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AppOld {
  /*
   * PrintWriter by default has auto-flush disabled.
   * When you write to PrintWriter using write, print, println, etc. everything is
   * buffered in writer. Only when you call flush() the buffered content will be
   * redirected to out stream.
   */

  public static void writeToConsole() {
    PrintWriter output = new PrintWriter(System.out);
    output.println("hello");
    output.flush();

    output = new PrintWriter(System.out, true);
    output.println("hello");
  }

  /*
   * This server has blocking problem. It can only accept one host at once. It
   * accepts one socket, then performs echo operation and then loses all
   * information about connection because next iteration of loop starts.
   */

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8080)) {
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String echoString = input.readLine();
        if (echoString.equals("exit"))
          break;

        // simulate long-running task
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        output.println("<<< " + echoString + " >>>");
      }
    } catch (IOException e) {
      System.out.println("Server exception: " + e.getMessage());
    }
  }
}
