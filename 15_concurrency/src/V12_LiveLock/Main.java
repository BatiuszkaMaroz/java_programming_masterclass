package V12_LiveLock;

public class Main {
  /*
   * A thread often acts in response to the action of another thread. If the other
   * thread's action is also a response to the action of another thread, then
   * livelock may result. As with deadlock, livelocked threads are unable to make
   * further progress. However, the threads are not blocked — they are simply too
   * busy responding to each other to resume work.
   *
   * Livelock is a opposition to deadlock situation.
   * - In deadlock we have two (or more) threads blocked.
   * - In livelock we have two (or more threads) responding to each other to
   * resume work.
   */
  public static void main(String[] args) {
    final Worker worker1 = new Worker("Worker 1", true);
    final Worker worker2 = new Worker("Worker 2", true);

    final SharedResource sharedResource = new SharedResource(worker1);

    new Thread(new Runnable() {
      @Override
      public void run() {
        worker1.work(sharedResource, worker2);
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        worker2.work(sharedResource, worker1);
      }
    }).start();

  }
}
