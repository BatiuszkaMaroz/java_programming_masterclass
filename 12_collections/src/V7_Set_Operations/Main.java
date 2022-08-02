package V7_Set_Operations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Set<Integer> positive = new HashSet<>();
    Set<Integer> negative = new HashSet<>();

    for (int i = 0; i <= 3; i++) {
      positive.add(i);
      negative.add(-i);
    }

    System.out.println("positive = " + positive);
    System.out.println("negative = " + negative);

    System.out.println("==================================================");

    Set<Integer> union = new HashSet<>();
    union.addAll(positive);
    union.addAll(negative);

    System.out.println("union = " + union);

    // ==================================================

    Set<Integer> intersection = new HashSet<>(positive);
    intersection.retainAll(negative);

    System.out.println("intersection = " + intersection);

    // ==================================================

    Set<Integer> difference = new HashSet<>(positive);
    difference.removeAll(negative);

    System.out.println("difference (P - N) = " + difference);

    // ==================================================

    Set<Integer> alternative = new HashSet<>(union);
    alternative.removeAll(intersection);

    System.out.println("alternative = " + alternative);

    // ==================================================

    Set<Integer> positiveSubset = new HashSet<>(Arrays.asList(1, 2, 3));

    System.out.println("positiveSubset is subset of positive = " + positive.containsAll(positiveSubset));
  }

}
