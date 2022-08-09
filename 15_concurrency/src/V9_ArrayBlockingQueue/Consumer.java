package V9_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
  private ArrayBlockingQueue<String> buffer;
  private String color;

  public Consumer(ArrayBlockingQueue<String> buffer, String color) {
    this.buffer = buffer;
    this.color = color;
  }

  private void println(String text) {
    System.out.println(color + text + Colors.ANSI_RESET);
  }

  @Override
  public void run() {
    while (true) {
      synchronized (buffer) {
        try {
          if (buffer.isEmpty())
            continue;

          if (buffer.peek().equals(Main.EOF)) {
            println("Exiting...");
            break;
          }

          println("Removed " + buffer.take() + ".");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
