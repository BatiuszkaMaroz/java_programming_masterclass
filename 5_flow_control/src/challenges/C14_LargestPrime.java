package challenges;

public class C14_LargestPrime {
  public static boolean isPrime(int n) {
    if (n <= 1)
      return false;

    if (n == 2)
      return true;
    if (n % 2 == 0)
      return false;

    for (int i = 3; i <= Math.sqrt(n); i++)
      if (n % i == 0)
        return false;

    return true;
  }

  public static int getLargestPrime(int n) {
    if (n <= 1)
      return -1;

    for (int i = n; i > 1; i--) {
      if (n % i != 0)
        continue;

      if (isPrime(i))
        return i;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(getLargestPrime(45));
  }
}
