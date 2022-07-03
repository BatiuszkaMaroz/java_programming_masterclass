public class V2_ForLoop {
  public static boolean isPrime(int n) {
    if (n <= 1)
      return false;

    /*
     * optimization:
     * two is the only one even prime number
     */

    if (n == 2)
      return true;

    if (n % 2 == 0)
      return false;

    /*
     * sqrt(n) as condition because
     * n = 100
     * sqrt(n) = 10
     *
     * 100 =
     * 1 * 100
     * 2 * 50
     * 4 * 25
     * 5 * 20
     * 10 * 10
     * *passed sqrt*
     * 20 * 5
     * 25 * 4
     * 50 * 2
     * 100 * 1
     */

    for (int i = 3; i <= Math.sqrt(n); i++)
      if (n % i == 0)
        return false;

    return true;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++)
      if (isPrime(i))
        System.out.println(i);
  }
}
