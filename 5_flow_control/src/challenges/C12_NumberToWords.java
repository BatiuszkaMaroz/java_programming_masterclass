package challenges;

public class C12_NumberToWords {
  static String[] numDict = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

  public static int getDigitCount(int n) {
    if (n == 0)
      return 1;
    if (n < 0)
      return -1;

    int c = 0;

    while (n != 0) {
      c++;
      n /= 10;
    }

    return c;
  }

  public static int reverse(int n) {
    int res = 0;

    while (n != 0) {
      res *= 10;
      res += n % 10;
      n /= 10;
    }

    return res;
  }

  public static void numberToWords(int n) {
    if (n == 0) {
      System.out.println(numDict[0]);
      return;
    }
    if (n < 0) {
      System.out.println("Invalid Value");
      return;
    }

    int len = getDigitCount(n);
    n = reverse(n);

    while (len != 0) {
      System.out.println(numDict[n % 10]);
      n /= 10;
      len--;
    }
  }
}
