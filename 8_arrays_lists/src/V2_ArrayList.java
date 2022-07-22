import java.util.ArrayList;
import java.util.Arrays;

public class V2_ArrayList {
  public static void main(String[] args) {
    /*
     * [Specification]
     * ArrayList is implemented as an array of Objects that can be resized.
     * Extending is creating new array that is 50% larger than old one,
     * and then copying elements from old to new.
     *
     * [Time Complexity]
     * - insert last: O(1) / O(n) if array is being extended
     * - insert at index: O(n)
     * - get by index: O(1)
     * - search/index of: O(n)
     * - remove: O(n)
     */

    /*
     * 1D array list
     */

    ArrayList<String> arr = new ArrayList<>();

    arr.add("first");
    arr.add("second");
    arr.add("forth");
    arr.set(2, "third");

    System.out.println(Arrays.toString(arr.toArray()));

    for (String elm : arr)
      System.out.println(elm);

    /*
     * Constructors
     */

    new ArrayList<String>();
    new ArrayList<String>(10);
    new ArrayList<String>(Arrays.asList("first", "second", "third"));

    /*
     * Other ways of initialization
     */

    new ArrayList<String>() {
      {
        add("first");
        add("second");
        add("third");
      }
    };

    /*
     * Methods
     */

    arr.size();
    arr.toArray();

    arr.get(0);
    arr.set(0, "first");

    arr.contains("second");
    arr.indexOf("third");

    // insert at index
    arr.add(0, "zero");

    // remove at index
    arr.add("forth");
    arr.remove(3);

    // remove first occurrence
    arr.add("forth");
    arr.remove("forth");

    arr.addAll(Arrays.asList("forth", "fifth", "sixth"));

    System.out.println(Arrays.toString(arr.toArray()));

    /*
     * 2D array list
     */

    int rows = 3;
    int cols = 3;
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(rows);

    for (int i = 0; i < rows; i++)
      matrix.add(new ArrayList<>(cols));

    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        matrix.get(i).add((j + 1) + i * 3);

    System.out.println(Arrays.deepToString(matrix.toArray()));
  }
}
