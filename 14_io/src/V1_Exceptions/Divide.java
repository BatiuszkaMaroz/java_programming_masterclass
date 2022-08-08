package V1_Exceptions;

public class Divide {
  // Look Before You Leave
  private static int divideLBYL(int a, int b) {
    if (b != 0)
      return a / b;
    else
      return 0;
  }

  // Easy to Ask for Forgiveness and Permission
  private static int divideEAFP(int a, int b) {
    try {
      return a / b;
    } catch (ArithmeticException e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(divideLBYL(10, 0));
    System.out.println(divideEAFP(10, 0));
    System.out.println(10 / 0);
  }
}
