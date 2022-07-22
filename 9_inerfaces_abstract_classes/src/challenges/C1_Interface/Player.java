package challenges.C1_Interface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Player implements ISaveable {
  private String name;
  private String weapon;
  private int hitPoints;
  private int strength;

  public Player(String name, int hitPoints, int strength) {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;

    weapon = "Sword";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWeapon() {
    return weapon;
  }

  public void setWeapon(String weapon) {
    this.weapon = weapon;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  @Override
  public void read(List<String> list) {
    if (list == null || list.size() < 4)
      return;

    Iterator<String> i = list.iterator();

    name = i.next();
    hitPoints = Integer.parseInt(i.next());
    strength = Integer.parseInt(i.next());
    weapon = i.next();
  }

  @Override
  public List<String> write() {
    return new LinkedList<String>(Arrays.asList(name, hitPoints + "", strength + "", weapon));
  }

  @Override
  public String toString() {
    return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}",
        name, hitPoints, strength, weapon);
  }
}
