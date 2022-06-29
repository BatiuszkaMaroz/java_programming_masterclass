
public class V3_Statements {
  static class Car {
    //
  }

  public static void main(String[] args) {
    /*
     * statements can be compared to sentences in natural language
     * in java there are 3 types of statements
     */

    /*
     * 1. declaration statement - declares variable
     */

    int score = 50; // data type at front and semicolon at end make it a declaration statement

    /*
     * 2. expression statement
     */

    // a) assignment expressions (because score = 50 returns 50)
    score = 50;
    score *= 2;

    // b) increment/decrement expressions
    score++;
    score--;

    // addding semicolons to a) and b) expressions convert them into
    // expression statements

    // c) method calls

    System.out.println("HELLO");

    // d) object creation expressions

    Car car = new Car();

    /*
     * 3. control flow statement
     */

    if (score < 100) {
      //
    }
  }
}
