package challenges.C1_Interface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Monster implements ISaveable {
  private String name;
  private int hitPoints;
  private int strength;

  public Monster(String name, int hitPoints, int strength) {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
  }

  public String getName() {
    return name;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public int getStrength() {
    return strength;
  }

  @Override
  public void read(List<String> list) {
    if (list == null || list.size() < 3)
      return;

    Iterator<String> i = list.iterator();

    name = i.next();
    hitPoints = Integer.parseInt(i.next());
    strength = Integer.parseInt(i.next());
  }

  @Override
  public List<String> write() {
    return new LinkedList<String>(Arrays.asList(name, hitPoints + "", strength + ""));
  }

  @Override
  public String toString() {
    return String.format("Monster{name='%s', hitPoints=%d, strength=%d}", name, hitPoints, strength);
  }
}
