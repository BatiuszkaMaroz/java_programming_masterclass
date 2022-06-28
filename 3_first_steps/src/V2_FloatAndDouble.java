public class V2_FloatAndDouble {
  public static void main(String[] args) {
    /*
     * float - single precision (32 bits), 6 to 7 decimal digits
     * double - double precision (64 bits), 15 decimal digits
     *
     * double is accepted as "default" for real numbers
     * double should be used all the time because:
     * - it has wider range of numbers than float
     * - on most machines will be probably faster than float
     * - most libraries uses double instead of float
     */

    // float f = 5.25; // causes error because double is "default"
    float f = 5.25f;
    double d = 5.25;

    int v1 = 5 / 3;
    float v2 = 5f / 3f;
    // double v3 = 5 / 3; // = 1.0 because (5 / 3) executed as int division
    double v3 = 5d / 3d;
    // double v3 = 5.0 / 3.0; // also correct

    System.out.println("v1 = " + v1);
    System.out.println("v2 = " + v2);
    System.out.println("v3 = " + v3);

    int pounds = 200;
    double kilograms = pounds * 0.453_592_37d;
    System.out.println("kilograms = " + kilograms);
  }
}
