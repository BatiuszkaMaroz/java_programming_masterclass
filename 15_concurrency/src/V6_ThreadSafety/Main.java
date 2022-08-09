package V6_ThreadSafety;

public class Main {
  /*
   * Thread cannot be suspended in the middle of atomic operations:
   * - read/write reference variables e.g. [obj1 == obj2],
   * - read/write primitive variables (with exception of long/double),
   * - volatile variables.
   *
   * Some collections aren't thread-safe and we have to do synchronization on our
   * own e.g. ArrayList. It gives better performance than for example synchronized
   * Vector but at the cost of possible errors if we don't synchronize it.
   *
   * Implementation of ArrayList is not synchronized by default. It means if a
   * thread modifies it structurally and multiple threads access it concurrently,
   * it must be synchronized externally. Structural modification implies the
   * addition or deletion of element(s) from the list or explicitly resizes the
   * backing array.
   *
   * ArrayList is not synchronized so thread can be suspended in the middle of
   * running the remove method (before actual removal of item).
   */
  public static void main(String[] args) {
    // blah blah
  }
}
