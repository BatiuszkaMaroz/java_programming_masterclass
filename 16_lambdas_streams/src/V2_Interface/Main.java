package V2_Interface;

public class Main {
  /*
   * Lambda expression is not a class (like anonymous class). When code runs,
   * anonymous class is not created from lambda, instead it's treated like a
   * nested block of code that has the same scope as a nested block would have.
   */

  public static void main(String[] args) {
    Operator operator01 = new Operator();

    String str1 = "Jane";
    String str2 = "Boe";

    operator01.classOrder(str1, str2);
    operator01.lambdaOrder(str1, str2);
  }
}
