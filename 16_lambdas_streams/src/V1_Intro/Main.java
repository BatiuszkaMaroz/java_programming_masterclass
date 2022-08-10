package V1_Intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello!");
      }
    }).start();

    /*
     * We can use lambda expression when one of the classes constructors
     * accepts an interface that has an only one method.
     *
     * Number of paramenters and return type are known because of that interface.
     */
    new Thread(() -> System.out.println("Hello!")).start();

    new Thread(() -> {
      System.out.println("Hello!");
      System.out.println("Hello!");
      System.out.println("Hello!");
    }).start();

    // ==================================================

    List<Employee> employees = new ArrayList<>();

    Employee e1 = new Employee("Adam", 11);
    Employee e2 = new Employee("Barbare", 23);
    Employee e3 = new Employee("Charlie", 75);
    Employee e4 = new Employee("Diana", 40);

    employees.add(e1);
    employees.add(e2);
    employees.add(e3);
    employees.add(e4);

    Collections.shuffle(employees);
    System.out.println(employees);

    // list.sort(new Comparator<Employee>() {
    // @Override
    // public int compare(Employee o1, Employee o2) {
    // return o1.getName().compareTo(o2.getName());
    // };
    // });

    /*
     * Lambda returns which is great!
     */
    employees.sort((Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName()));

    /*
     * We can also get rid of type in parameters.
     */
    employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

    System.out.println(employees);

    // ==================================================

    /*
     * We can also omit parentheses if one parameter and assign lambdas to
     * variables.
     */

    Operation<String> operation = str -> str.toUpperCase();

    String res = executeStringOperation(operation, "Ala has cat.");
    System.out.println(res);
  }

  public static String executeStringOperation(Operation<String> fn, String str) {
    return fn.operation(str);
  }
}
