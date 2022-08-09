package V7_Locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static final String EOF = "EOF";

  /*
   * Drawbacks of using synchronized statements/methods:
   * - threads that are waiting to execute code can't be interrupted, they are
   * stuck until getting lock,
   * - block must be within same method, so we cannot start synchronize block in
   * one method and end it in another,
   * - we can't get any info about lock state.
   * - we can't set timeout for waiting for lock,
   * - there is no order which thread will get the lock first.
   *
   * Locks doesn't have this drawbacks!
   */

  /*
   * Critical-section code should be inside try..finally block, and in finally
   * block there should be code responsible for unlocking lock. If error happens
   * in critical-section block, lock will be released and we won't have deadlock.
   *
   * Also with usage of try..finally you have to make unlock() only one, so it's
   * cleaner code.
   */

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();

    /*
     * We can add fairness argument to ReentrantLock, it will try to be fair when
     * selecting which thread will get lock.
     *
     * Also timeout can be specified on lock.
     *
     * Also number of threads waiting for lock can be checked.
     */
    // ReentrantLock lock = new ReentrantLock(true);
    // lock.wait(1000);
    // lock.getQueueLength()

    Producer p = new Producer(list, Colors.ANSI_RED, lock);
    Consumer c1 = new Consumer(list, Colors.ANSI_BLUE, lock);
    Consumer c2 = new Consumer(list, Colors.ANSI_CYAN, lock);

    (new Thread(p)).start();
    (new Thread(c1)).start();
    (new Thread(c2)).start();
  }
}
