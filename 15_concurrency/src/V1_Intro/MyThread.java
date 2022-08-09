package V1_Intro;

/*
 * Import static, very interesting.
 */
import static V1_Intro.Colors.ANSI_BLUE;
import static V1_Intro.Colors.ANSI_RESET;

public class MyThread extends Thread {
  public MyThread(String name) {
    super(name);
  }

  public void print(String text) {
    System.out.println(ANSI_BLUE + text + ANSI_RESET);
  }

  @Override
  public void run() {
    print("Hello from " + currentThread().getName() + " thread.");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      print("Interrupted by another thread.");
      return;
    }

    print("Woken up after sleep.");
  }
}
