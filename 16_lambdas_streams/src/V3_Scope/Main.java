package V3_Scope;

import java.util.ArrayList;
import java.util.List;

import V1_Intro.Employee;

public class Main {
  public static void printValue() {
    int num = 25;

    /*
     * Difference between AIC (anonymous inner class) and lambda is that AICs are
     * creating new scope (have own this) and lambdas does not. Also AICs can be
     * subclassed and can implement multi-method interfaces.
     */

    /*
     * In AIC / lambda we can only reference final or effective final
     * (value never changed) variables that are outside AIC / lambda.
     *
     * It's showed on below example.
     * Printing variable in lambda code will execute after printValue() method
     * completion. So variable num will no longer exist. So lambda has to remember
     * value of variable in order to print it (that's what happens under the hood).
     * But if we would be able to change value of variable in printValue() then
     * lambda would have obsolete value and that could lead to problems.
     */

    // num++; // error
    // num = 30; // error

    Runnable r = () -> {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("num = " + num);
    };

    // num++; // error
    // num = 30; // error

    new Thread(r).start();
  }

  public static void main(String[] args) {
    printValue();

    // ==================================================

    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("Adam", 11));
    employees.add(new Employee("Barbare", 23));
    employees.add(new Employee("Charlie", 75));
    employees.add(new Employee("Diana", 40));

    /*
     * We can reference "employees" elements in lambda using enhanced for loop
     * because it creates new "e" variable for each iteration which is effectively
     * final until we change it.
     */
    for (Employee e : employees) {
      // e = null; // error
      new Thread(() -> System.out.println(e.getName()));
    }
  }
}
