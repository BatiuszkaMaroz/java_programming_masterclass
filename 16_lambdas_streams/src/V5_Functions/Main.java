package V5_Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import V1_Intro.Employee;

public class Main {
  /*
   * Functions (and other functional interfaces implementations) can be passed to
   * methods in order to achieve different results using one method.
   */
  public static String getName(Employee employee, Function<Employee, String> function) {
    return function.apply(employee);
  }

  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();

    list.add(new Employee("Adam Something", 11));
    list.add(new Employee("Barbare Abracadabra", 23));
    list.add(new Employee("Charlie Chaplin", 75));
    list.add(new Employee("Diana Anna", 40));

    /*
     * Function accepts one argument and returns value.
     */
    Function<Employee, String> getLastName = e -> {
      return e.getName().split(" ")[1];
    };

    Function<Employee, String> getFirstName = e -> {
      return e.getName().split(" ")[1];
    };

    list.forEach(e -> {
      // String firstName = getFirstName.apply(e);
      // String lastName = getLastName.apply(e);

      String firstName = getName(e, getFirstName);
      String lastName = getName(e, getLastName);

      System.out.println(firstName + " " + lastName);
    });
  }
}
