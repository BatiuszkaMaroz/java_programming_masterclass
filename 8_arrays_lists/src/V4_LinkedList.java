import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class V4_LinkedList {
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void insertionSort(LinkedList<String> list) {
    /*
     * ListIterator is a cursor used to traverse through collection.
     * It extends Iterator interface.
     * Can move in both directions.
     * It is placed BETWEEN to nodes.
     * Can perform all CRUD operations.
     *
     * set() operation replaces last returned element,
     * so it depends whether 'next' or 'prev' was called earlier
     */

    ListIterator<String> i = list.listIterator(1);

    while (i.hasNext()) {
      ListIterator<String> j = list.listIterator(i.nextIndex());
      String key = i.next();

      while (j.hasPrevious()) {
        String elm = j.previous();

        if (elm.compareTo(key) > 0) {
          j.next();
          j.next();
          j.set(elm);
          j.previous();
          j.previous();
        } else {
          j.next();
          break;
        }
      }

      j.next();
      j.set(key);
    }
  }

  public static void printList(LinkedList<String> list) {
    /*
     * Iterator is a cursor used to traverse through collection.
     * Can move forward only.
     * Can perform READ and DELETE operations.
     */

    Iterator<String> i = list.iterator();

    System.out.println();
    while (i.hasNext())
      System.out.print(i.next() + ", ");
    System.out.println();
  }

  public static void main(String[] args) {
    /*
     * Specification
     *
     * LinkedList is a bidirectional doubly linked list.
     *
     * Time Complexity
     * - insert last: O(1)
     * - insert at index: O(n)
     * - get by index: O(n)
     * - search/index of: O(n)
     * - remove: O(n)
     *
     * Usage of iterators can improve overall complexity.
     * Iterators are very good for removing elements
     * (if you have for loop you have to decrease i value, iterator is more
     * convenient here).
     */

    LinkedList<String> list = new LinkedList<String>();
    list.add("Alex");
    list.add("Charles");
    list.add("Diana");
    list.add("Felipe");

    printList(list);

    list.add(1, "Betty");
    list.add(4, "Eugene");

    printList(list);

    list.remove(5);
    list.remove(4);

    printList(list);

    // ==============================

    LinkedList<String> list2 = new LinkedList<String>();
    list2.add("F");
    list2.add("A");
    list2.add("C");
    list2.add("D");
    list2.add("B");
    list2.add("E");

    insertionSort(list2);
    System.out.println();

    /*
     * this for loop uses Iterator under the hood
     */

    for (String elm : list2)
      System.out.print(elm + ", ");

    System.out.println();
  }
}
