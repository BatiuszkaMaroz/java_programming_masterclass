import java.util.ArrayList;

public class V3_Boxing {
  public static void main(String[] args) {
    /*
     * every primitive type has its own wrapper class
     * e.g. int and Integer
     *
     * conversion:
     * Integer.valueOf(10) => Integer
     * var.intValue() => int
     */

    Integer i1 = new Integer(10);

    // assigning int to Integer
    Integer i2 = 20; // under the hood: Integer.valueOf(20)

    // assignint Integer to int
    int i3 = i1; // under the hood: i1.intValue()

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);

    /*
     * primitive type cannot be used in ArrayList
     * ArrayList<int> arr = new ArrayList<>();
     * this will produce error
     *
     * AUTOBOXING
     * conversion from primitive type to corresponding wrapper class
     * e.g. int => Integer
     * Integer.valueOf(10)
     *
     * UNBOXING
     * conversion from wrapper class to corresponding primitive type
     * e.g. Integer => int
     * var.intValue()
     */

    // AUTOBOXING
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < 10; i++)
      arr.add(Integer.valueOf(i));

    // UNBOXING
    for (int i = 0; i < 10; i++)
      System.out.println(i + ": " + arr.get(i).intValue());
  }
}
