package challenges;

public class C7_SharedDigit {
  // space complexity: O(10)
  // time complexity: O(2n)
  public static boolean hasSharedDigit(int n1, int n2) {
    if (n1 < 10 || n2 < 10 || n1 > 99 || n2 > 99)
      return false;

    boolean[] arr = new boolean[10];

    while (n1 != 0) {
      arr[n1 % 10] = true;
      n1 /= 10;
    }

    while (n2 != 0) {
      if (arr[n2 % 10])
        return true;
      n2 /= 10;
    }

    return false;
  }
}
