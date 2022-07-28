package V1_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    // BINARY SEARCH
    // ==================================================

    Theatre t1 = new Theatre("Atlantic", 5, 5);

    /*
     * Binary way faster than linear search, who might have thought...
     */

    t1.reserveSeatBinary("D01");
    t1.reserveSeatLinear("D01");
    t1.reserveSeatBinary("D02");

    // t1.showSeats();

    // COPYING
    // ==================================================

    List<Seat> list = t1.getSeats();

    /*
     * ArrayList constructor takes capacity as argument, capacity is amount of
     * memory allocated not actual size of array. That's why below code won't work.
     */

    // listCopy = new ArrayList<>(list.size());
    // Collections.copy(listCopy, list);

    List<Seat> listCopy = new ArrayList<>(list);

    /*
     * Copy is shallow of course.
     */

    listCopy.get(0).setReserved(true);
    t1.reserveSeatBinary("A01");

    // COLLECTIONS FRAMEWORK
    // ==================================================

    /*
     * Collections api provide us many useful functions. Some of them require
     * elements of array to implement Comparable interface e.g. sort().
     */

    Collections.shuffle(list);
    Collections.swap(list, 0, list.size() - 1);
    Collections.sort(list);
    Collections.reverse(list);

    /*
     * O(n) - linear search
     *
     * Searchin min/max is made in linear time complexity. It is better than sorting
     * and then using binary search which is O(n log n).
     */
    System.out.println("Max seat = " + Collections.max(list).getId());
    System.out.println("Min seat = " + Collections.min(list).getId());
  }
}