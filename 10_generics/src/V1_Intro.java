import java.util.ArrayList;

public class V1_Intro {
  public static void printArray(ArrayList arr) {
    for (Object elm : arr)
      System.out.println(elm);

    /*
     * this will throw error if at least one element
     * cannot be casted to Integer (e.g. String)
     */

    // for (Object elm : arr)
    // System.out.println((Integer) elm);
  }

  public static void main(String[] args) {

    /*
     * program compiles but can generate horrible errors during runtime
     * NEVER USE IT !!!
     */

    ArrayList arr = new ArrayList();

    arr.add(1);
    arr.add(2);
    arr.add("three");
    arr.add(4.25);

    printArray(arr);
  }
}
