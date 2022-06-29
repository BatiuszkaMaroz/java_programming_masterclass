public class V4_Operators {
  public static void operators() {
    int mul = 5;
    int res = 10 * mul;

    /*
     * [10] and [mul] are operands
     * [res] is a operator
     * [10 * mul] is a expression
     *
     * expression is a combination of operators (>= 1) and operands (>= 1) that
     * computes to produce/return another value during process called evaluation
     * e.g. int a = 1, (1 + 2)
     */

    int i = 50;
    i %= 6; // xd
    System.out.println(i);

    /*
     * assignment operator "=" returns value assigned to variable
     */

    boolean cond = false;
    if (cond = true)
      System.out.println("oh!");

    int val = 10;
    if ((val = 20) > 10)
      System.out.println("oh!");

    int n1, n2, n3;
    n1 = n2 = n3 = 10;

    /*
     * Operator precedence:
     * http://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html
     */
  }

  public static void challenge2() {
    double n1 = 20.0;
    double n2 = 80.0;
    double n3 = (n1 + n2) * 100.0;
    double n4 = n3 % 40.0;

    boolean res = n4 == 0;
    System.out.println(res);

    if (res)
      System.out.println("No remainder!");
  }

  public static void main(String[] args) {
    // operators();
    challenge2();
  }
}
