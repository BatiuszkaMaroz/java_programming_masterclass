
public class V1_Operators {
  public static void main(String[] args) {
    int a;

    /*
     * operators associativity
     *
     * 1. left-associative (left-to-right)
     * operators of the same precedence are evaluated in order from left to right
     * example: (10 + 5 - 20)
     * 10 + 5 evaluates first
     * 15 - 20 evaluates next
     *
     * 2. right-associative (right-to-left)
     * operators of the same precedence are evaluated in order from right to left
     * example: int a = 10 * 5;
     * 10 * 5 evaluates first
     * a = 15 evaluates next
     */

    /*
     * all java right-associative operators
     */

    /*
     * assignment operators
     */

    a = 1;
    a += 1; // because a = a + 1
    a -= 1;
    a *= 2;
    a /= 2;
    a %= 2;

    /*
     * ternary operator
     */

    a = 10;
    a = a >= 10 ? a >= 10 ? 20 : 0 : 0;
    System.out.println(a);

    // because
    // (a >= 10 ? 20 : 0) evaluates first
    // a >= 10 ? (a >= 10 ? 20 : 0) : 0 evaluates next

    /*
     * prefix unary operators
     */

    ++a;
    --a;
    // +a;
    // -a;
    // !a;
    // ~a;
    // (int) a;

    /*
     * IMPORTANT
     * postfix unary operators are left-associative
     */

    a++;
    a--;

    // in prefix a = a + 1 standard assignment expression is executed
    // (a = a + 1 returns a + 1)
    // in postfix a is returned firstly and then a = a + 1 expression is evaluated
  }
}
