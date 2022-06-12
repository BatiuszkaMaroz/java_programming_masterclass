package com.david.part2;

import static com.david.part2.Color.*;

class Countdown {
  private int i = 10;

  // synchronized method can be executed only by one thread at a time
  // public synchronized void startCountdown() {
  public void startCountdown() {
    String color;

    switch (Thread.currentThread().getName()) {
      case "Thread 1":
        color = ANSI_CYAN;
        break;
      case "Thread 2":
        color = ANSI_PURPLE;
        break;
      default:
        color = ANSI_GREEN;
    }

    // synchronization happens on argument passed to synchronized()
    // argument become monitor object and synchronization takes place on this object
    synchronized (this) {
      i = 10;
      while (i-- > 0)
        System.out.println(color + Thread.currentThread().getName() + ": i = " + i + ANSI_RESET);
    }
  }
}

class CountdownThread extends Thread {
  private Countdown countdown;

  public CountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  public void run() {
    countdown.startCountdown();
  }
}

public class App {
  public static void main(String[] args) {
    Countdown countdown = new Countdown();

    CountdownThread t1 = new CountdownThread(countdown);
    t1.setName("Thread 1");

    CountdownThread t2 = new CountdownThread(countdown);
    t2.setName("Thread 2");

    t1.start();
    t2.start();
  }
}
