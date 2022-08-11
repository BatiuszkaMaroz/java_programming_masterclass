package V4_Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
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
    list.add(new Employee("Eugene", 30));

    // forEach
    // ==================================================

    System.out.println("===== >= 30 agers =====");

    list.forEach(e -> {
      if (e.getAge() >= 30)
        System.out.println(e);
    });

    // Consumer -> 1 arg, no return
    // ==================================================
    System.out.println("===== 30 agers =====");

    Consumer<Employee> consumer = e -> {
      if (e.getAge() == 30)
        System.out.println(e);
    };

    list.forEach(consumer);

    // Predicate -> 1 arg, return true/false
    // ==================================================

    System.out.println("===== < 30 agers =====");

    Predicate<Employee> condition = e -> e.getAge() < 30;
    for (Employee e : list) {
      if (condition.test(e))
        System.out.println(e);
    }

    System.out.println("==== (-100, 100) number =====");

    // Supplier -> 0 arg, return value
    // ==================================================

    Random random = new Random();

    Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

    System.out.println(randomSupplier.get());
    System.out.println(randomSupplier.get());
    System.out.println(randomSupplier.get());
  }
}
