package V9_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
  private ArrayBlockingQueue<String> buffer;
  private String color;

  public Producer(ArrayBlockingQueue<String> buffer, String color) {
    this.buffer = buffer;
    this.color = color;
  }

  private void println(String text) {
    System.out.println(color + text + Colors.ANSI_RESET);
  }

  @Override
  public void run() {
    String[] nums = { "1", "2", "3", "4", "5" };

    for (String num : nums) {
      try {
        println("Adding " + num + "...");
        buffer.put(num);

        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    println("Adding EOF...");
    try {
      buffer.put(Main.EOF);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
