package V13_LooseEnds;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
  /*
   * An atomic operation is an operation which is performed as a single unit of
   * work without the possibility of interference from other operations.
   *
   * The Java language specification guarantees that READING or WRITING a variable
   * is an atomic operation (unless the variable is of type long or double).
   * Operations variables of type long or double are only atomic if they are
   * declared with the VOLATILE keyword.
   */

  /*
   * To put it simply, volatile signals to the compiler and the virtual machine
   * that a variable marked in this way can be shared by threads. Therefore, the
   * compiler and runtime (JVM) should avoid:
   * - changing the sequence of memory operations,
   * - various optimizations, e.g. consisting in caching the value of a variable.
   */
  volatile double j = 1.2345d;

  public static void main(String[] args) {
    /*
     * Increment/Decrement ain't atomic opo. It's combination of reading, adding and
     * writing. But with the usage of AtomicVariables they become atomic.
     */
    AtomicInteger i = new AtomicInteger(0);

    i.incrementAndGet();
    i.incrementAndGet();

    System.out.println(i);
  }
}
