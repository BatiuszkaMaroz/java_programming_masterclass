package V11_Starvation_Fairlock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
  /*
   * Starvation describes a situation where a thread is unable to gain regular
   * access to shared resources and is unable to make progress. This happens when
   * shared resources are made unavailable for long periods by "greedy" threads.
   */

  /*
   * To fix starvation problem we can use "fair lock" as it will try to be fair
   * while giving threads a lock.
   */

  // lock + synchronized
  // private static Object lock = new Object();

  // lock
  // private static ReentrantLock lock = new ReentrantLock();

  // fair lock
  private static ReentrantLock lock = new ReentrantLock(true);

  private static class Worker implements Runnable {
    private int i = 1;
    private String threadColor;

    public Worker(String threadColor) {
      this.threadColor = threadColor;
    }

    // @Override
    // public void run() {
    // while (i <= 100) {
    // synchronized (lock) {
    // System.out.format(threadColor + "%s: runCount = %d\n",
    // Thread.currentThread().getName(), i++);
    // // execute critical section of code
    // }
    // }
    // }
    // }

    @Override
    public void run() {
      while (i <= 100) {
        lock.lock();
        try {
          System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), i++);
        } finally {
          lock.unlock();
        }
      }
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
    Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
    Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
    Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
    Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

    t1.setPriority(10);
    t2.setPriority(8);
    t3.setPriority(6);
    t4.setPriority(4);
    t5.setPriority(2);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
