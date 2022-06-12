package com.david.part1;

import static com.david.part1.Color.*;

public class CustomRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_RED + "Hello from CustomRunnable implementation of run()");
  }
}
