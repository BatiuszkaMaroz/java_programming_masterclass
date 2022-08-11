package V9_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  /*
   * Streams can't be reused, if you use it once it can't be used anymore (will
   * throw exception).
   * There are IntStream and others.
   * And parallel streams exist too.
   */

  public static void main(String[] args) {
    Department hr = new Department("Human Resources");
    Department accounting = new Department("Accounting");

    hr.addEmployee(new Employee("Adam", 11));
    hr.addEmployee(new Employee("Barbare", 23));
    hr.addEmployee(new Employee("Charlie", 75));
    hr.addEmployee(new Employee("Diana", 40));
    accounting.addEmployee(new Employee("Eugene", 12));
    accounting.addEmployee(new Employee("Fiona", 79));
    accounting.addEmployee(new Employee("Gregory", 31));
    accounting.addEmployee(new Employee("Hannah", 19));

    List<Department> departs = Arrays.asList(hr, accounting);

    departs
        .stream()
        .flatMap(d -> d.getList().stream())
        .forEach(System.out::println);

    // collect
    // ==================================================

    List<Employee> employees = departs
        .stream()
        .flatMap(d -> d.getList().stream())
        .collect(Collectors.toList());

    System.out.println(employees);

    // ==================================================

    employees = departs
        .stream()
        .flatMap(d -> d.getList().stream())
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    System.out.println(employees);

    // groupingBy
    // ==================================================

    Map<Integer, List<Employee>> groupedByDecades = departs
        .stream()
        .flatMap(d -> d.getList().stream())
        .collect(Collectors.groupingBy(e -> e.getAge() / 10 * 10));

    System.out.println(groupedByDecades);

    // reduce
    // ==================================================

    departs
        .stream().flatMap(d -> d.getList().stream())
        .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
        .ifPresent(System.out::println);

    /*
     * In reduce to obtain element we can use get() or orElse(other).
     * get() throws NoSuchElementException if element not found, while orElse will
     * provide us with default value if element not found.
     */

    Employee oldest = departs
        .stream().flatMap(d -> d.getList().stream())
        .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
        // .get()
        .orElse(null);

    System.out.println(oldest);

    // ==================================================

    /*
     * Operations in streams are lazily evaluated meaning if there is no terminal
     * operation, whole chain won't be executed at all.
     */

    departs
        .stream().flatMap(d -> d.getList().stream())
        .filter(e -> {
          System.out.println("Hallo!");
          return e.getAge() >= 18;
        });
  }
}