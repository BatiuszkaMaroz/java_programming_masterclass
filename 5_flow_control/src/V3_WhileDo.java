public class V3_WhileDo {
  public static int sumDigit(int n) {
    if (n < 0)
      n *= -1;

    int sum = 0;
    for (int exp = 1; exp <= n; exp *= 10)
      sum += (n / exp) % 10;

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(sumDigit(-541));
  }
}
