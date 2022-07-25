import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class V2_Imports {
  public static void main(String[] args) {
    /*
     * Imported in first import
     */

    Stack stack = null;
    Queue queue = null;

    /*
     * Imported in second import
     */

    Callable call = null;

    /*
     * Imported in third import
     */

    Lock lock = null;

    /*
     * Adding asterisk to the import, imports all Interfaces and Classess at given
     * namespace, but only on that depth. It does not go deeper.
     *
     * [Example]
     * `import java.util.*;`
     * This line will import every class and interface at this path but
     * it won't import anything from nested packages.
     * So classes and interfaces from `java.util.concurrent.*`
     * won't be imported using this line.
     */
  }
}
