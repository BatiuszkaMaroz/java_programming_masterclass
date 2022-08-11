package challenges.C1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    Runnable runnable = () -> {
      String str = "Ala has cat";
      List<String> list = Arrays.asList(str.split(" "));

      list.forEach(System.out::println);
    };

    try {
      Thread t = new Thread(runnable);
      t.start();
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println();
    }

    // ==================================================

    Function<String, String> everySecondChar = input -> {
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < input.length(); i += 2)
        res.append(input.charAt(i));

      return res.toString();
    };

    System.out.println(everySecondChar.apply("H,e,l,l,o, ,w,o,r,l,d,!"));

    // ==================================================

    BiConsumer<String, Function<String, String>> customPrinter = (input, fn) -> System.out.println(fn.apply(input));

    customPrinter.accept("H,e,l,l,o, ,w,o,r,l,d,!", everySecondChar);
  }
}
