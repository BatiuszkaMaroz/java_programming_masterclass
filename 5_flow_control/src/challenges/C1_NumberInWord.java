package challenges;

public class C1_NumberInWord {
  public static void printNumberInWord(int n) {
    String[] arr = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "OTHER" };

    if (n < 0 || n > 9)
      n = 10;

    System.out.println(arr[n]);
  }
}
