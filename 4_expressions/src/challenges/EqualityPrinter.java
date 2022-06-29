package challenges;

public class EqualityPrinter {
  public static void printEqual(int a, int b, int c) {
    if (a < 0 || b < 0 || c < 0) {
      System.out.println("Invalid Value");
      return;
    }

    int score = 0;

    if (a == b)
      score++;
    if (b == c)
      score++;
    if (a == c)
      score++;

    if (score == 3)
      System.out.println("All numbers are equal");
    else if (score == 0)
      System.out.println("All numbers are different");
    else
      System.out.println("Neither all are equal or different");
  }
}
