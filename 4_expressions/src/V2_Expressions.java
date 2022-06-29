public class V2_Expressions {
  public static int getPosition(int score) {
    if (score >= 1000)
      return 1;
    else if (score >= 500)
      return 2;
    else if (score >= 100)
      return 3;
    else
      return 4;
  }

  public static void main(String[] args) {
    /*
     * expression is a combination of operators (>= 1) and operands (>= 1) that
     * computes to produce/return another value during process called evaluation
     * e.g.
     * a = 1 => produces 1
     * (1 + 2) => produces 3
     *
     * statement on the other hand is just a standalone unit of execution and
     * doesn't return anything
     * e.g.
     * int a = 1;
     * if(a > 3) {...}
     */

    // km = 100 * 1.609344 is an expression
    // but whole line is a statement
    double km = 100 * 1.609344;

    // whole condition is a statement
    // everything in parentheses is an expression
    if (km > 100)
      // everything in parentheses is an expression
      System.out.println("OK");

    // statement
    km++;

    // prefix - alter variable BEFORE expression EVALUATION
    // postfix - alter variable AFTER expression EVALUATION
    int x = 10;
    System.out.println("x = " + x);
    System.out.println("PREFIX x = " + --x);
    System.out.println("POSTFIX x = " + x--);

    x = 10;
    while (x-- > 0) // compares first then decrements
      System.out.print(x + ", ");
    System.out.println("");

    x = 10;
    while (--x > 0) // decrements first then compares
      System.out.print(x + ", ");
    System.out.println("");

    int a = 10;
    int b = 24;
    int c = 5;
    System.out.println(a-- * (++b / c--)); // = 10 * (25 / 5) = 50

    System.out.println(getPosition(1000));
    System.out.println(getPosition(500));
    System.out.println(getPosition(100));
    System.out.println(getPosition(50));
  }
}
