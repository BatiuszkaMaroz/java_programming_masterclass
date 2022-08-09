package V2_Join;

public class Main {
  public static void main(String[] args) {
    Thread t1 = new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(Colors.ANSI_BLUE + "Thread interrupted.");
          return;
        }

        System.out.println(Colors.ANSI_BLUE + "Thread finished.");
      }
    };

    /*
     * When we invoke the join() method on a thread, the calling thread goes into a
     * waiting state. It remains in a waiting state until the referenced thread
     * terminates.
     */
    Thread t2 = new Thread() {
      @Override
      public void run() {
        try {
          t1.join();
        } catch (InterruptedException e) {
          System.out.println(Colors.ANSI_CYAN + "Thread interrupted.");
          return;
        }

        System.out.println(Colors.ANSI_CYAN + "Thread finished.");
      }
    };

    /*
     * We can set max timeout for method to wait.
     */
    Thread t3 = new Thread() {
      @Override
      public void run() {
        try {
          t1.join(500);
        } catch (InterruptedException e) {
          System.out.println(Colors.ANSI_PURPLE + "Thread interrupted.");
          return;
        }

        System.out.println(Colors.ANSI_PURPLE + "Thread finished or timed out.");
      }
    };

    t1.start();
    t2.start();
    t3.start();
  }
}
