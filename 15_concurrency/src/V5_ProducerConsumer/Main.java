package V5_ProducerConsumer;

/*
 * Idea of program is we have one writer and one reader. Writer writes a message
 * and then waits 0 to 1 second and reader reads message and waits 0 to 1
 * second.
 */

public class Main {
  public static void main(String[] args) {
    Message m = new Message();

    (new Thread(new Writer(m))).start();
    (new Thread(new Reader(m))).start();
  }
}
