public class V1_Numbers {
  static public void ranges() {
    // 8 bits, whole numbers
    System.out.println("Byte MAX = " + Byte.MAX_VALUE);
    System.out.println("Byte MIN = " + Byte.MIN_VALUE);
    byte b = 127;

    // 16 bits, whole numbers
    System.out.println("Short MAX = " + Short.MAX_VALUE);
    System.out.println("Short MIN = " + Short.MIN_VALUE);
    short s = 32_767;

    // 32 bits, whole numbers
    System.out.println("Integer MAX = " + Integer.MAX_VALUE);
    System.out.println("Integer MIN = " + Integer.MIN_VALUE);
    int i = 2_147_483_647;

    // 64 bits, whole numbers
    System.out.println("Long MAX = " + Long.MAX_VALUE);
    System.out.println("Long MIN = " + Long.MIN_VALUE);
    long l = 9_223_372_036_854_775_807L; // "L" should be added at the end

    // 32 bits, fractional numbers, sufficient for 6 to 7 decimal digits
    // usually not used, double is preferred
    System.out.println("Float MAX = " + Float.MAX_VALUE);
    System.out.println("Float MIN = " + Float.MIN_VALUE);
    float f = 1.123456f; // "f" should be added at the end

    // 64 bits, fractional numbers, sufficient for 15 decimal digits
    System.out.println("Double MAX = " + Double.MAX_VALUE);
    System.out.println("Double MIN = " + Double.MIN_VALUE);
    double d = 1.123456789012345d; // "d" should be added at the end
  }

  public static void overflow() {
    /*
     * overflow happens when value exceeds max/min range of data type
     * (bit overflow)
     */

    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;

    if (max + 1 == min && min - 1 == max)
      System.err.println("overflow");
  }

  public static void transforms() {
    /*
     * if "L" is not added, value transforms to int
     *
     * 123 - byte/short/int
     * 123L - long
     * 123.0f - float
     * 123.0 / 123.0d - double
     *
     * integer is accepted as "default" for whole numbers
     * double is accepted as "default" for real numbers
     */

    long l1 = 2_147_483_647 * 2; // will transform to int
    long l2 = 2_147_483_647L * 2; // ok
    long l3 = 2_147_483_647 * 2L; // ok
    // long l4 = 2_147_483_648; // error: type int is out of range
    long l5 = 2_147_483_648L; // ok

    System.out.println("l1 = " + l1); // overflow (on interger)
    System.out.println("l2 = " + l2); // correct
    System.out.println("l3 = " + l3); // correct
  }

  public static void typeCasting() {
    int intMin = Integer.MIN_VALUE;
    int byteMin = Byte.MIN_VALUE;

    int v1 = (intMin / 2);
    // byte v2 = (byteMin / 2); // error: cannot convert from int to byte
    byte v2 = (byte) (byteMin / 2);
    short v3 = (short) (intMin / 2);
  }

  static public void challenge1() {
    byte b = 1;
    short s = 10;
    int i = 100;

    /*
     * (b + s + i) transforms to int
     * (100 + 1L) transforms to long
     * an expression transforms to largest data type
     */

    long longTotal = 20_000L + 10 * (b + s + i);
    System.out.println("longTotal = " + longTotal);

    short shortTotal = (short) (20_000 + 10 * (b + s + i));
    System.out.println("shortTotal = " + shortTotal);
  }

  public static void main(String[] args) throws Exception {
    ranges();
    overflow();
    transforms();
    typeCasting();
    challenge1();
  }
}
