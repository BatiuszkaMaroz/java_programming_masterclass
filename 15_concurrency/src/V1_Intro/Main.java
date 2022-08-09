package V1_Intro;

import static V1_Intro.Colors.ANSI_GREEN;
import static V1_Intro.Colors.ANSI_RESET;;

public class Main {
  public static void main(String[] args) {
    /*
     * To start thread use start() not run(). If you start thread with run() it will
     * run on thread that called that method, in this case on main thread.
     * Thread can be started only one time.
     */

    Thread t = new MyThread("== My Thread ==");

    // t.setName("== My Thread =="); // name can be set by setter :D
    // t.run(); // will run on main thread

    t.start();
    t.interrupt();

    // ==================================================

    new Thread() {
      public void run() {
        System.out.println("Hello from anonymous thread.");
      }
    }.start();

    // ==================================================

    t = new Thread(new MyRunnable());
    t.start();

    // ==================================================

    t = new Thread(new MyRunnable() {
      @Override
      public void print(String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
      }
    });
    t.start();
  }
}
