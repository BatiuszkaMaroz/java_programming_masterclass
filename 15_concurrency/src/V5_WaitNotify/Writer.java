package V5_WaitNotify;

import java.util.Random;

public class Writer implements Runnable {
  private Message message;
  private Random random = new Random();

  public Writer(Message message) {
    this.message = message;
  }

  /*
   * Thread.sleep() is a static method so it's called on class.
   */
  @Override
  public void run() {
    String[] messages = { "Hello", "my", "dear", "world", "!" };

    for (int i = 0; i < messages.length; i++) {
      message.write(messages[i]);

      try {
        Thread.sleep((random.nextInt(1000)));
      } catch (InterruptedException e) {
        //
      }
    }

    message.write("Finished");
  }
}