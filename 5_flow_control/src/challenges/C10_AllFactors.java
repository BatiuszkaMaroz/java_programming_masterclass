package challenges;

public class C10_AllFactors {
  public static void printFactors(int n) {
    if (n < 1) {
      System.out.println("Invalid Value");
      return;
    }

    for (int i = 1; i <= n; i++)
      if (n % i == 0)
        System.out.println(i);
  }
}
