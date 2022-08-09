package V9_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
  public static final String EOF = "EOF";

  public static void main(String[] args) {
    /*
     * Thread-safe class means that only one method on class instance can be run at
     * a time. Another method or another (or same) thread will start only after
     * firstly called method will complete.
     *
     * So we can be sure that there is only one thread working on an instance at a
     * time but still we can have problems if multiple method calls depend on each
     * other like in consumer class, that's why adding synchronized block is
     * required.
     *
     * And that's why even if class is thread-safe we need to synchronize it
     * sometimes too.
     */
    ArrayBlockingQueue<String> list = new ArrayBlockingQueue<>(10);

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Producer p = new Producer(list, Colors.ANSI_RED);
    Consumer c1 = new Consumer(list, Colors.ANSI_BLUE);
    Consumer c2 = new Consumer(list, Colors.ANSI_CYAN);

    executorService.execute(p);
    executorService.execute(c1);
    executorService.execute(c2);

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
