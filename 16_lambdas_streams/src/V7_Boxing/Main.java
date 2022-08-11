package V7_Boxing;

import java.util.Random;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntPredicate;
import java.util.function.LongSupplier;

public class Main {
  private static final Random random = new Random();

  public static void main(String[] args) {
    /*
     * We can use pre-typed interfaces to avoid auto/un-boxing.
     */

    // Predicate
    // ==================================================

    IntPredicate upperLim = i -> i < 100;
    IntPredicate lowerLim = i -> i > -100;

    System.out.println("-100 = " + upperLim.and(lowerLim).test(-100));
    System.out.println("-50 = " + upperLim.and(lowerLim).test(-50));
    System.out.println("50 = " + upperLim.and(lowerLim).test(50));
    System.out.println("100 = " + upperLim.and(lowerLim).test(150));

    // Supplier
    // ==================================================

    LongSupplier randomSupplier = () -> random.nextLong(1000);
    System.out.println(randomSupplier.getAsLong());

    // Function
    // ==================================================

    DoubleUnaryOperator powerOfTwo = i -> Math.pow(2, i);
    System.out.println(powerOfTwo.applyAsDouble(10));
  }
}
