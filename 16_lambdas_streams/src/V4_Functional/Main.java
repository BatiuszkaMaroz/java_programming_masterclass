package V4_Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import V1_Intro.Employee;

public class Main {
  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();

    list.add(new Employee("Adam", 11));
    list.add(new Employee("Barbare", 23));
    list.add(new Employee("Charlie", 75));
    list.add(new Employee("Diana", 40));

    // forEach
    // ==================================================

    System.out.println("===== >= 30 agers =====");

    list.forEach(e -> {
      if (e.getAge() >= 30)
        System.out.println(e);
    });

    // Predicate -> test for true/false
    // ==================================================

    System.out.println("===== < 30 agers =====");

    Predicate<Employee> condition = e -> e.getAge() < 30;
    for (Employee e : list) {
      if (condition.test(e))
        System.out.println(e);
    }

    System.out.println("==== (-100, 100) number =====");

    /*
     * That happens under the hood. Every lambda creates own "i" in it's code block.
     * But if we declare "int i" outside that will cause errors.
     */
    // {
    // int i;
    // return i < 100;
    // }

    /*
     * We use IntPredicate instead of Predicate<Integer> to avoid unnecessary
     * auto/un-boxing.
     */
    IntPredicate upperLim = i -> i < 100;
    IntPredicate lowerLim = i -> i > -100;

    System.out.println("-100 = " + upperLim.and(lowerLim).test(-100));
    System.out.println("-50 = " + upperLim.and(lowerLim).test(-50));
    System.out.println("50 = " + upperLim.and(lowerLim).test(50));
    System.out.println("100 = " + upperLim.and(lowerLim).test(150));

    // Supplier -> return value
    // ==================================================

    Random random = new Random();
    Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

    System.out.println(randomSupplier.get());
    System.out.println(randomSupplier.get());
    System.out.println(randomSupplier.get());
  }
}
