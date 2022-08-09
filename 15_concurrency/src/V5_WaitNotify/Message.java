package V5_WaitNotify;

public class Message {
  private String message;
  private boolean empty = true;

  /*
   * Because read() and write() methods are `synchronized` that means that
   * synchronization takes place on object/instance of Message. So it's correct
   * that both wait() and notifyAll() methods are in fact called on "this".
   *
   * - notifyAll() wakes up all threads suspended on object.
   * - notify() wakes up single, randomly selected thread from threads suspended
   * on object.
   */

  public synchronized String read() {
    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        //
      }
    }

    empty = true;
    notify();

    return message;
  }

  public synchronized void write(String message) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        //
      }
    }

    empty = false;
    notify();

    this.message = message;
  }
}
