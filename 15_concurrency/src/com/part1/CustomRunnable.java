package com.part1;

import static com.part1.Color.*;

public class CustomRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_RED + "Hello from CustomRunnable implementation of run()");
  }
}
