package com.part1;

import static com.part1.Color.*;

public class CustomThread extends Thread {

  @Override
  public void run() {
    System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName() + "." + ANSI_RESET);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      System.out.println(ANSI_BLUE + "Thread interrupted." + ANSI_RESET);
      return;
    }

    System.out.println(ANSI_BLUE + currentThread().getName() + " awaken after three seconds." + ANSI_RESET);
  }
}
