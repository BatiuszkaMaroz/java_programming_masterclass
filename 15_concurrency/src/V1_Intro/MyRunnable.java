package V1_Intro;

import static V1_Intro.Colors.ANSI_RED;
import static V1_Intro.Colors.ANSI_RESET;

public class MyRunnable implements Runnable {
  public void print(String text) {
    System.out.println(ANSI_RED + text + ANSI_RESET);
  }

  @Override
  public void run() {
    print("Hello from runnable.");
  }
}
