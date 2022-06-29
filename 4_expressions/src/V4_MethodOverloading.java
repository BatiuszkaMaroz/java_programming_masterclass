public class V4_MethodOverloading {
  // 1I = 2,54CM
  static final double INCH_TO_CM_RATIO = 2.54;
  // 1F = 12I
  static final double FEET_TO_INCH_RATIO = 12.0;

  /*
   * method declaration consist of
   * - access modifiers
   * - return type
   * - name
   * - parameter list
   *
   * method body does stuff
   *
   * method overload is reusing same method name on different methods
   * they have to differ in paramenters
   */

  public static double inchToCm(double inches) {
    return inches * INCH_TO_CM_RATIO;
  }

  public static double feetToInch(double feet) {
    return feet * FEET_TO_INCH_RATIO;
  }

  public static double toCm(int inches) {
    return inchToCm(inches);
  }

  // overloaded method
  public static double toCm(int feet, int inches) {
    return inchToCm(feetToInch(feet)) + inchToCm(inches);
  }

  // ========================================

  // https://www.javatpoint.com/java-string-format
  public static final String MESSAGE_FORMAT = "%02dh %02dm %02ds";

  public static String getDurationString(int min, int sec) {
    if (min < 0 || sec < 0 || sec > 59)
      return "Invalid value";

    int hour = min / 60;
    min %= 60;

    return String.format(MESSAGE_FORMAT, hour, min, sec);
  }

  public static String getDurationString(int sec) {
    if (sec < 0)
      return "Invalid value";

    int min = sec / 60;
    sec %= 60;

    return getDurationString(min, sec);
  }

  // ========================================

  public static void main(String[] args) {
    System.out.println(toCm(5, 11));
    System.out.println(toCm(5 * 12 + 11));

    // built-in overloaded method
    System.out.println(1);
    System.out.println(21.37);
    System.out.println('a');
    System.out.println("Hello!");

    System.out.println(getDurationString(81, 37));
    System.out.println(getDurationString(81 * 60 + 37));
  }
}
