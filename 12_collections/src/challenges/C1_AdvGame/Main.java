package challenges.C1_AdvGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  private Scanner sc = new Scanner(System.in);
  private Map<Integer, Location> locations = new HashMap<Integer, Location>();
  private Map<String, String> directions = new HashMap<>();

  public Main() {
    locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
    locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
    locations.put(2, new Location(2, "You are at the top of a hill"));
    locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
    locations.put(4, new Location(4, "You are in a valley beside a stream"));
    locations.put(5, new Location(5, "You are in the forest"));

    locations.get(1).addExit("W", 2);
    locations.get(1).addExit("E", 3);
    locations.get(1).addExit("S", 4);
    locations.get(1).addExit("N", 5);

    locations.get(2).addExit("N", 5);

    locations.get(3).addExit("W", 1);

    locations.get(4).addExit("N", 1);
    locations.get(4).addExit("W", 2);

    locations.get(5).addExit("S", 1);
    locations.get(5).addExit("W", 2);

    // ==================================================

    directions.put("north", "N");
    directions.put("east", "E");
    directions.put("south", "S");
    directions.put("west", "W");
    directions.put("quit", "Q");
  }

  private void printDescription(Location loc) {
    System.out.println(loc.getDescription());
  }

  private void printExits(Location loc) {
    System.out.print("Available exits are ");

    for (String key : loc.getExits().keySet())
      System.out.print(key + ", ");

    System.out.println();
  }

  public void command() {
    int cur = 1;
    while (true) {
      Location loc = locations.get(cur);
      printDescription(loc);

      if (cur == 0)
        break;

      printExits(loc);

      String line = sc.nextLine().toLowerCase();
      String key = null;

      for (String word : line.split(" +")) {
        key = directions.get(word);
        if (key != null)
          break;
      }

      if (key == null || !loc.getExits().containsKey(key)) {
        System.out.println("You cannot go in that direction");
        continue;
      }

      cur = loc.getExits().get(key);
    }
  }
}