package V8_ThreadPools;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
  private List<String> buffer;
  private String color;
  private ReentrantLock lock;

  public Consumer(List<String> buffer, String color, ReentrantLock lock) {
    this.buffer = buffer;
    this.color = color;
    this.lock = lock;
  }

  private void println(String text) {
    System.out.println(color + text + Colors.ANSI_RESET);
  }

  @Override
  public void run() {
    while (true) {
      lock.lock();
      try {
        if (buffer.isEmpty())
          continue;

        if (buffer.get(0).equals(Main.EOF)) {
          println("Exiting...");
          break;
        }

        println("Removed " + buffer.remove(0) + ".");
      } finally {
        lock.unlock();
      }
    }
  }
}
