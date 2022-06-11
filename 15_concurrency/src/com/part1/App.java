package com.part1;

import static com.part1.Color.*;

public class App {

  public static void main(String[] args) {
    System.out.println(ANSI_PURPLE + "Hello from the main thread." + ANSI_RESET);

    Thread customThread = new CustomThread();
    customThread.setName("=^-^= Cat Thread =^-^=");
    customThread.start();

    // thread cannot be started multiple times
    // customThread.start();

    // executing `run` directly will run code on current thread
    // customThread.run();

    new Thread() {
      public void run() {
        System.out.println(ANSI_GREEN + "Hello from the anonymous class thread." + ANSI_RESET);
      }
    }.start();

    new Thread(new CustomRunnable() {
      @Override
      public void run() {
        System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()." + ANSI_RESET);

        try {
          // max time to wait can be set
          // customThread.join(1000);

          customThread.join();
          System.out.println(ANSI_RED + "CustomThread terminated or timed out. Continuing execution." + ANSI_RESET);
        } catch (InterruptedException e) {
          System.out.println(ANSI_RED + "Thread interrupted." + ANSI_RESET);
        }
      }
    }).start();

    System.out.println(ANSI_PURPLE + "Hello again from the main thread." + ANSI_RESET);
  }
}
