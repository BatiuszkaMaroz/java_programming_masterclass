package challenges;

public class DecimalComparator {
  public static boolean areEqualByThreeDecimalPlaces(double n1, double n2) {
    n1 *= Math.pow(10, 3);
    n2 *= Math.pow(10, 3);

    return (int) n1 == (int) n2;
  }

  public static void main(String[] args) {
    double d1 = 123.456;

    int exp = 100;
    int res = (int) ((d1 * exp) % 10);

    System.out.println(res);
  }
}
