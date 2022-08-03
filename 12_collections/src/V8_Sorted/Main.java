package V8_Sorted;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Map<String, Integer> hashMap = new HashMap<>();
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    Map<String, Integer> treeMap = new TreeMap<>();

    String[] keys = { "Alpha", "Beta", "Gamma", "Delta" };

    for (String key : keys) {
      hashMap.put(key, 0);
      linkedHashMap.put(key, 0);
      treeMap.put(key, 0);
    }

    /*
     * HashMap - chaotic order.
     */
    System.out.println("hash = " + hashMap);

    /*
     * LinkedHashMap - putting order.
     */
    System.out.println("linked = " + linkedHashMap);

    /*
     * TreeMap - sorted order (ascending).
     *
     * Uses red-black tree under the hood (self-balancing BST) so basic operations
     * like put, get, etc. takes O(log n) time.
     *
     * Custom comparator can be provided.
     */

    Map<String, Integer> reversedTreeMap = new TreeMap<>(Comparator.reverseOrder());
    reversedTreeMap.putAll(treeMap);

    System.out.println("tree = " + treeMap);
    System.out.println("reversed tree = " + reversedTreeMap);

    /*
     * Unmodifiable map can't be modified.
     */

    Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(hashMap);
    // unmodifiableMap.put("Alpha", 0); // error
    // unmodifiableMap.put("Epsilon", 0); // error
  }
}
