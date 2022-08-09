package V3_Interference;

class Countdown {
  private int i;

  public void start() {
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
     * A "race condition" / "thread interference" occurs when two or more threads
     * can access shared data and they try to change it at the same time. Because
     * the thread scheduling algorithm can swap between threads at any time, you
     * don't know the order in which the threads will attempt to access the shared
     * data.
     *
     * It work like that:
     * Thread_1 does something and gets suspended, Thread_2 does something and gets
     * suspended, Thread_1 ..., and so on.
     *
     * Variable i is shared between threads but countdown still counts from 10 to 0
     * because [i--] in fact is [i = i - 1].
     */
    for (i = 10; i >= 0; i--)
      System.out.println(color + Thread.currentThread().getName() + ": " + i + Colors.ANSI_RESET);
  }
}

class CountdownThread extends Thread {
  private Countdown countdown;

  public CountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  @Override
  public void run() {
    countdown.start();
  }
}

public class Main {
  public static void main(String[] args) {
    Countdown c = new Countdown();

    Thread t1 = new CountdownThread(c);
    t1.setName("Thread 1");

    Thread t2 = new CountdownThread(c);
    t2.setName("Thread 2");

    t1.start();
    t2.start();

    /*
     * We can resolve thread interference problem using two separate countdowns or
     * synchronizing method.
     */
  }
}
