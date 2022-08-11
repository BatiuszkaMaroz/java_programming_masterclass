package challenges.C2;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> names = Arrays.asList(
        "amelia",
        "Olivia",
        "emily",
        "Isla",
        "Ava",
        "oliver",
        "jack",
        "Charlie",
        "harry",
        "Jacob");

    names
        .stream()
        .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
        .sorted()
        .forEach(System.out::println);

    System.out.println("==================================================");

    int aCount = (int) names
        .stream()
        .filter(s -> s.charAt(0) == 'a' || s.charAt(0) == 'A')
        .peek(System.out::println)
        .count();

    System.out.println("==================================================");
    System.out.println(aCount);
  }
}
