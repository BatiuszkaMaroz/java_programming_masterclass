package challenges;

public class C4_NumberPalindrome {
  /*
   * idea:
   * shift digits in rev one step left
   * get lowest digit from temp then add it to rev and reduce temp
   */
  public static boolean isPalindrome(int n) {
    int temp = n;
    int rev = 0;

    while (temp != 0) {
      rev *= 10;
      rev += temp % 10;

      temp /= 10;
    }

    return n == rev;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(112211));
    System.out.println(isPalindrome(-12321));
    System.out.println(isPalindrome(112233));
    System.out.println(isPalindrome(-1234567));
  }
}
