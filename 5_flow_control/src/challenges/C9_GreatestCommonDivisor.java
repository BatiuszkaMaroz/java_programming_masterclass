package challenges;

public class C9_GreatestCommonDivisor {
  public static int getGreatestCommonDivisor(int a, int b) {
    if (a < 10 || b < 10)
      return -1;

    while (true) {
      if (a == 0)
        return b;
      if (b == 0)
        return a;

      if (a == b)
        return a;

      if (a > b)
        a -= b;
      else
        b -= a;
    }
  }
}
