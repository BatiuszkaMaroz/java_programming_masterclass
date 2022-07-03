
import java.util.Scanner;

public class V5_Input {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int age;
    while (true) {
      System.out.println("Enter YOB: ");
      if (sc.hasNextInt()) {
        age = 2022 - sc.nextInt();
        break;
      } else
        sc.next();
    }

    System.out.println("Enter name:");
    String name = sc.next();

    System.out.println(String.format("Hey there %s, aged %d years old, how re ya?", name, age));
    sc.close();
  }
}
