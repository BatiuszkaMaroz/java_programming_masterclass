package challenges;

public class C5_SumFirstAndLastDigit {
  public static int sumFirstAndLastDigit(int n) {
    if (n < 0)
      return -1;

    int res = n % 10;

    while (n >= 10)
      n /= 10;

    res += n;
    return res;
  }
}
