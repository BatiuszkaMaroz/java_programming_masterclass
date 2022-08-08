package V1_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
  private static Scanner sc = new Scanner(System.in);

  private static int getInt() {
    int n = sc.nextInt();
    return n;
  }

  private static int getIntLBYL() {
    System.out.println("LBYL");

    while (!sc.hasNextInt()) {
      System.out.println("Incorrect!");
      sc.next();
    }

    int n = sc.nextInt();
    return n;
  }

  private static int getIntEAFP() {
    System.out.println("EAFP");

    int n;
    while (true) {
      try {
        n = sc.nextInt();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Incorrect!");
        sc.next();
      }
    }

    return n;
  }

  public static void main(String[] args) {
    int x;

    x = getInt();
    x = getIntLBYL();
    x = getIntEAFP();

    System.out.println(x);
  }
}
