package V1_Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  /*
   * In Java there are checked and unchecked exceptions.
   * - checked - checked at compile time.
   * - unchecked - thrown during program execution.
   */

  /*
   * Exception - event that occurs during proram execution that disrupts normal
   * flow of program.
   *
   * Two ways of dealing with dangerouse code:
   * - LBYL - Look Before You Leave,
   * - EAFP - Easy to Ask for Forgiveness and Permission.
   *
   * In Java there is Exception class and many other subclasses of it like
   * ArithmeticException. You can catch just Exception but this doesn't say
   * anything about it. That's why it's better to use specific exceptions.
   *
   * Stacktrace - trace of stack, it's just methods loaded on stack while stack
   * did error. Read stack trace from BOTTOM to TOP.
   *
   * Don't let to happen situation when exception is thrown in catch block.
   * Catch blocks should be short and readable.
   */

  private static Scanner sc = new Scanner(System.in);

  /*
   * InputMismatchException is caught but
   * NoSuchElementException is not.
   */
  private static int getInt() {
    while (true) {
      try {
        return sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Incorrect!");
        sc.next();
      }
    }
  }

  /*
   * Throwing own exceptions allows to provide message and gives shorter
   * stacktrace which increases readability.
   *
   * If you do this kind of re-throwing, remember to throw exception of the same
   * type.
   */
  private static int divide() {
    int x, y;

    try {
      x = getInt();
      y = getInt();

      return x / y;
    } catch (ArithmeticException e) {
      throw new ArithmeticException("dividing by zero");
    } catch (NoSuchElementException e) {
      throw new NoSuchElementException("no suitable input");
    }
  }

  /*
   * Catching multiple exceptions in one catch block is also possible.
   */
  public static void main(String[] args) {
    try {
      int res = divide();
      System.out.println("result = " + res);
    } catch (ArithmeticException | NoSuchElementException e) {
      System.out.println("an error occurred");
      System.out.println(e.toString());
    }
  }
}
