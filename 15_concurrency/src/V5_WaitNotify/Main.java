package V5_WaitNotify;

public class Main {
  /*
   * Idea of program is we have one writer and one reader. Writer writes a message
   * and then waits 0 to 1 second and reader reads message and waits 0 to 1
   * second.
   */

  /*
   * We can use wait(), notify(), notifyAll() only after obtaining objects
   * monitor.
   * We get monitor when:
   * - when we've executed synchronized instance method for the given object,
   * - when we've executed the body of a synchronized block on the given object.
   */

  public static void main(String[] args) {
    Message m = new Message();

    (new Thread(new Writer(m))).start();
    (new Thread(new Reader(m))).start();
  }
}
