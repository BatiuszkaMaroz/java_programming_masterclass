package V8_ThreadPools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  /*
   * Thread pool is managed set of threads.
   * It can limit the number of active threads. So if there is maximum number of
   * threads active in thread pool, other threads will be added to queue.
   *
   * More info in notes.
   */

  public static final String EOF = "EOF";

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Producer p = new Producer(list, Colors.ANSI_RED, lock);
    Consumer c1 = new Consumer(list, Colors.ANSI_BLUE, lock);
    Consumer c2 = new Consumer(list, Colors.ANSI_CYAN, lock);

    /*
     * We can use classess that implement Runnable to be submitted as tasks.
     */
    executorService.execute(p);
    executorService.execute(c1);
    executorService.execute(c2);

    /*
     * Or classess that implement Callable if we expect value to be returned. For
     * retreiving this value we use Future interface.
     *
     * Callable as an improved version of Runnable that can return values.
     */
    Future<String> future = executorService.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(500);

        System.out.println(Colors.ANSI_YELLOW + "Callable class." + Colors.ANSI_RESET);
        return "Callable result.";
      }
    });

    try {
      System.out.println(future.get());
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    executorService.shutdown();
  }
}
