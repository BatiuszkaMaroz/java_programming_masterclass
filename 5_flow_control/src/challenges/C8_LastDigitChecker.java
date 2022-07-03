package challenges;

public class C8_LastDigitChecker {
  // inclusive
  public static boolean isValid(int x) {
    int l = 10;
    int h = 1000;
    return l <= x && x <= h;
  }

  public static boolean hasSameLastDigit(int n1, int n2, int n3) {
    if (!isValid(n1) ||
        !isValid(n2) ||
        !isValid(n3))
      return false;

    return n1 % 10 == n2 % 10 || n1 % 10 == n3 % 10 || n2 % 10 == n3 % 10;
  }
}
