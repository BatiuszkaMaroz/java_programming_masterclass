import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
  private Socket socket;

  public Echoer(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedReader input = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

      while (true) {
        String message = input.readLine();
        if (message.equals("exit"))
          break;

        System.out.println("Received client input: " + message);

        // simulate long-running task
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        output.println("<<< " + message + " >>>");
      }
    } catch (IOException e) {
      System.out.println("Exception in Echoer: " + e.getMessage());
    } finally {
      try {
        socket.close();
        System.out.println("Client disconnected");
      } catch (IOException e) {
        System.out.println("Exception in Echoer: Socket couldn't be closed");
      }
    }
  }
}
