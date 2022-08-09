package V8_ThreadPools;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
  private List<String> buffer;
  private String color;
  private ReentrantLock lock;

  public Producer(List<String> buffer, String color, ReentrantLock lock) {
    this.buffer = buffer;
    this.color = color;
    this.lock = lock;
  }

  private void println(String text) {
    System.out.println(color + text + Colors.ANSI_RESET);
  }

  @Override
  public void run() {
    String[] nums = { "1", "2", "3", "4", "5" };

    for (String num : nums) {
      println("Adding " + num + "...");

      lock.lock();
      try {
        buffer.add(num);
      } finally {
        lock.unlock();
      }

      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        //
      }
    }

    println("Adding EOF...");

    lock.lock();
    try {
      buffer.add(Main.EOF);
    } finally {
      lock.unlock();
    }
  }
}
