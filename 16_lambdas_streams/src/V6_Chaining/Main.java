package V6_Chaining;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    String input = "hIeRoNiMuS";

    Function<String, String> lowercase = str -> str.toLowerCase();
    Function<String, String> capitalize = str -> Character.toUpperCase(str.charAt(0)) + str.substring(1);

    Function<String, String> chained = lowercase.andThen(capitalize);
    Function<String, String> composed = capitalize.compose(lowercase);

    String res1 = lowercase.andThen(capitalize).apply(input);
    String res2 = chained.apply(input);
    String res3 = composed.apply(input);

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);

    // ==================================================

    /*
     * BiFunction accepts 2 arguments.
     * If chained, BiFunction must be first in chain.
     *
     * There is also bi-versions of Supplier and Predicate.
     */

    BiFunction<Integer, Integer, Integer> sum = (i1, i2) -> i1 + i2;
    Function<Integer, String> intToStr = i -> i + "";

    BiFunction<Integer, Integer, String> sumAsStr = sum.andThen(intToStr);
    System.out.println(sumAsStr.apply(10, 20));
  }
}
