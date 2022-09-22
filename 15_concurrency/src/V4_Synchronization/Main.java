
package V4_Synchronization;

class Countdown {
  private int i;

  /*
   * Every java object has "intrinsic lock" (also called "monitor lock"). If
   * thread wants to execute synchronized method on object it must have lock. As
   * long as a thread owns an intrinsic lock, no other thread can acquire the same
   * lock.
   *
   * When thread has lock it can execute synchronized methods.
   *
   * When a thread invokes a synchronized method, it automatically acquires the
   * lock for that object (class instance) and releases it when the thread
   * completes its task.
   *
   * So only one synchronized method on object can be executed at the time. Rest
   * of the threads that want to execute any of synchronized methods on this
   * object are suspended. Non-synchronized methods are executed normally without
   * locking.
   */
  public synchronized void start1() {
    String color;

    switch (Thread.currentThread().getName()) {
      case "Thread 1":
        color = Colors.ANSI_BLUE;
        break;
      case "Thread 2":
        color = Colors.ANSI_CYAN;
        break;
      default:
        color = Colors.ANSI_RESET;
        break;
    }

    for (i = 10; i >= 0; i--)
      System.out.println(color + Thread.currentThread().getName() + ": " + i +
          Colors.ANSI_RESET);
  }

  public void start2() {
    String color;

    switch (Thread.currentThread().getName()) {
      case "Thread 1":
        color = Colors.ANSI_BLUE;
        break;
      case "Thread 2":
        color = Colors.ANSI_CYAN;
        break;
      default:
        color = Colors.ANSI_RESET;
        break;
    }

    /*
     * Unlike synchronized methods, synchronized statements must specify the object
     * that provides the intrinsic lock.
     *
     * Tips:
     * - In static methods you can synchronize on class (Countdown.class).
     * - Do not synchronize on string because they are pooled and often reused in
     * Java.
     */
    synchronized (this) {
      for (i = 10; i >= 0; i--)
        System.out.println(color + Thread.currentThread().getName() + ": " + i + Colors.ANSI_RESET);
    }
  }

  /*
   * Non synchronized methods are executed without locking.
   */
  public void start3() {
    String color = Colors.ANSI_RED;

    for (int i = 10; i >= 0; i--)
      System.out.println(color + Thread.currentThread().getName() + ": " + i + Colors.ANSI_RESET);
  }
}

class CountdownThread extends Thread {
  private Countdown countdown;

  public CountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  /*
   * We should synchronize only the code that have to be synchronized, so start2()
   * seems to be a better choice.
   */
  @Override
  public void run() {
    countdown.start1();
    // countdown.start2();
  }
}

class ReadonlyCountdownThread extends Thread {
  private Countdown countdown;

  public ReadonlyCountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  @Override
  public void run() {
    countdown.start3();
  }
}

public class Main {
  public static void main(String[] args) {
    /*
     * To resolve "race condition" we can synchronize methods and code blocks.
     *
     * Critical section is a code that's referencing a shared resource. Only one
     * thread at a time should be able to execute critical section.
     *
     * Thread-safe, when method or class is thread-safe it means that developer
     * synchronized all critical sections so we don't have to worry about thread
     * interference.
     */

    Countdown c = new Countdown();

    Thread t1 = new CountdownThread(c);
    t1.setName("Thread 1");

    Thread t2 = new CountdownThread(c);
    t2.setName("Thread 2");

    Thread t3 = new ReadonlyCountdownThread(c);
    t3.setName("Readonly Thread 3");

    t1.start();
    t2.start();
    t3.start();
  }
}
