package V5_ProducerConsumer;

import java.util.Random;

public class Reader implements Runnable {
  private Message message;
  private Random random = new Random();

  public Reader(Message message) {
    this.message = message;
  }

  /*
   * Thread.sleep() is a static method so it's called on class.
   */
  @Override
  public void run() {
    for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
      System.out.println(latestMessage);

      try {
        Thread.sleep((random.nextInt(1000)));
      } catch (InterruptedException e) {
        //
      }
    }
  }
}