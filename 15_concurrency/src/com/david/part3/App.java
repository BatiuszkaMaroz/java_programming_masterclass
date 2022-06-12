package com.david.part3;

import java.util.Random;

class Message {
  private String message;
  private boolean empty = true;

  public synchronized String read() {
    System.out.println("R");
    while (empty) {
      try {
        wait();
      } catch (InterruptedException err) {
        //
      }
    }

    empty = true;
    notifyAll();
    return message;
  }

  public synchronized void write(String message) {
    System.out.println("W");
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException err) {
        //
      }
    }

    empty = false;
    this.message = message;
    notifyAll();
  }
}

class Writer implements Runnable {
  Random random = new Random();
  private Message message;

  public Writer(Message message) {
    this.message = message;
  }

  public void run() {
    String messages[] = {
        "Humpty Dumpty sat on a wall",
        "Humpty Dumpty had a great fall",
        "All the king's horses and all the king's men",
        "Couldn't put Humpty together again",
    };

    for (int i = 0; i < messages.length; i++) {
      message.write(messages[i]);

      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException err) {
        //
      }
    }

    message.write("Finished");
  }
}

class Reader implements Runnable {
  Random random = new Random();
  private Message message;

  public Reader(Message message) {
    this.message = message;
  }

  public void run() {
    for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
      System.out.println(latestMessage);

      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException err) {
        //
      }
    }

  }
}

public class App {
  public static void main(String[] args) {
    Message message = new Message();

    (new Thread(new Writer(message))).start();
    (new Thread(new Reader(message))).start();
  }
}
