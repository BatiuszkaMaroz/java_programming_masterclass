package V5_Sets;

import java.util.HashSet;
import java.util.Set;

public class Main {
  /*
   * Sets:
   * - chaotic order,
   * - no duplicates,
   * - cannot "get()", only add, remove, contains,
   * - can perform sets operations (like on LTM).
   *
   * HashSet uses HashMap (since java 8) under the hood, it uses keys from HashMap
   * because they are unique.
   *
   *
   * If you use own object as set keys you SHOULD implement own
   * hashCode() and equals() method overrides.
   * Otherwise all elements will be added because compare will happen on object
   * reference.
   */

  /*
   * In arrays don't be scared to store heavy objects, in fact only pointers
   * to instances are being stored and a pointer is a size of int.
   */

  private static Set<Planet> planets = new HashSet<>();

  public static void main(String[] args) {
    planets.add(new Planet("Mercury", 88));
    planets.add(new Planet("Venus", 225));
    planets.add(new Planet("Earth", 365));

    planets.add(new Planet("Mars", 687));
    planets.add(new Planet("Mars", 697));
    planets.add(new Planet("Mars", 707));
    planets.add(new Planet("Mars", 717));

    for (Planet planet : planets)
      System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());

    System.out.println("Pluto".hashCode());
    System.out.println(new Planet("Pluto", 0).hashCode());
  }
}
