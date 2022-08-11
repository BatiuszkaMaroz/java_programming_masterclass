package V8_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    List<String> bingoNumbers = Arrays.asList(
        "A2", "A19",
        "B60", "B61",
        "C4", "C80",
        "d90", "D15", "d17", "D67");

    List<String> dNumbers = new ArrayList<>();

    bingoNumbers.forEach(n -> {
      if (n.toUpperCase().startsWith("D"))
        dNumbers.add(n.toUpperCase());
    });

    dNumbers.sort((n1, n2) -> n1.compareTo(n2));
    dNumbers.forEach(n -> System.out.println(n));

    System.out.println();

    // ==================================================

    /*
     * Any stream operations must meet two requirements;
     * - non-interfering, meaing operations don't change the stream source in any
     * way,
     * - stateless, meaning the result of any operation can't depend on any state
     * outside of the operation.
     *
     * Terminal operation is an operation in stream that returns void or non-stream
     * result, meaning we can't chain more methods on stream. forEach is an example
     * of terminal operation.
     */

    bingoNumbers
        .stream()
        .map(s -> s.toUpperCase())
        .filter(s -> s.startsWith("D"))
        .sorted()
        .forEach(s -> System.out.println(s));

    System.out.println();

    // ==================================================

    /*
     * String::toUpperCase is reference to method. So it's like passing a method.
     *
     * Sorted can accept function as argument otherwise it does natural-order
     * sorting.
     */

    bingoNumbers
        .stream()
        .map(String::toUpperCase)
        .filter(s -> s.startsWith("D"))
        .sorted()
        .forEach(System.out::println);

    System.out.println();

    /*
     * We can use these references normally.
     */

    bingoNumbers.forEach(System.out::println);

    System.out.println();

    // ==================================================

    /*
     * Peek unlike forEach returns stream so it can be chained.
     */

    Stream<String> stream1 = Stream.of("A", "B", "C");
    Stream<String> stream2 = Stream.of("C", "D", "E");
    Stream<String> stream3 = Stream.concat(stream1, stream2);

    System.out.println(
        stream3
            .distinct()
            .peek(System.out::println)
            .count());
  }
}
