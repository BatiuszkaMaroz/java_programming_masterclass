package V3_Maps;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    /*
     * [Map working internals]
     * Go to notes.md at root.
     */

    Map<String, String> map = new HashMap<>();

    map.put("tree", "Three steps north-east.");
    map.put("treasure", "Five steps south.");
    map.put("village", "One step north, one step south.");

    System.out.println(map.get("tree"));
    System.out.println(map.get("treasure"));
    System.out.println(map.get("village"));

    System.out.println("==================================================");

    /*
     * Result of map.put(<key>, <value>) operation is the latest value that was set
     * under <key>. If nothing was assigned at this <key> then null is returned.
     */

    String res1 = map.put("mountain", "Turn right, thousand steps backward.");
    String res2 = map.put("mountain", "Turn left, three steps forward.");

    System.out.println(res1);
    System.out.println(res2);

    System.out.println(map.containsKey("tree"));
    System.out.println(map.containsValue("Three steps north-east."));

    System.out.println("==================================================");

    String LastMntValue = map.remove("mountain");
    boolean treeWasRemoved = map.remove("tree", "Many steps somewhere.");

    System.out.println("mountain key last value = " + LastMntValue);
    System.out.println("tree was removed = " + treeWasRemoved);

    /*
     * Looping through map.
     */

    for (String key : map.keySet())
      System.out.println("key=" + key + " value=" + map.get(key));

    System.out.println("==================================================");

    /*
     * Replace only if value under key exists.
     */

    String res3 = map.replace("factory", "Path not found...");
    System.out.println("factory replace result = " + res3);

    /*
     *
     */

    Map<SameHash, Integer> sameMap = new HashMap<>();

    SameHash s1 = new SameHash("David");
    SameHash s2 = new SameHash("Jacob");

    sameMap.put(s1, 1);
    sameMap.put(s2, 2);

    System.out.println(s1.toString() + ": " + sameMap.get(s1));
    System.out.println(s2.toString() + ": " + sameMap.get(s2));
  }
}
