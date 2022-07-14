import java.util.Arrays;

public class V1_Array {
  public static void main(String[] args) throws Exception {
    /*
     * initialization
     *
     * numeric array default value is [0]
     * non-numeric array default value is [null]
     *
     * accessing index out of range throws [ArrayIndexOutOfBoundsException]
     */

    int[] arr1 = new int[10];
    int[] arr2 = { 1, 2, 3 };
    int[] arr3 = new int[] { 1, 2, 3 };

    // will throw error, this syntax can be used only in initialization
    // arr2 = { 1, 2, 3 };

    // assigning new array, that's correct
    arr3 = new int[] { 1, 2, 3 };

    /*
     * indexes
     * (remind c++ pointer-access)
     *
     * arr - address of 1st element
     * arr[4] - address of 5th element = (address of 1st element + (4 * sizeOfType))
     */

    /*
     * printing
     */

    System.out.println("arr1 = " + Arrays.toString(arr1));
    System.out.println("arr2 = " + Arrays.toString(arr2));
    System.out.println("arr3 = " + Arrays.toString(arr3));

    /*
     * members
     */

    System.out.println("arr2 length = " + arr2.length);

    // on arrays of dimension > 1, shallow copy is performed
    int[] clonedArr2 = arr2.clone();
    System.out.println("clonedArr2 = " + Arrays.toString(clonedArr2));
  }
}
