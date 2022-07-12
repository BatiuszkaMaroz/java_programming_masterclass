package com.dawidprajzner.V2_Encapsulation;

public class EnchantedPlayer {
  private String name;
  private int health;
  private String weapon;

  public EnchantedPlayer(String name, int health, String weapon) {
    if (health < 0 || 100 < health)
      health = 100;

    this.name = name;
    this.health = health;
    this.weapon = weapon;
  }

  public void loseHealth(int damage) {
    health -= damage;
    System.out.printf("%s: Got %d damage, remaining health = %d%n", name, damage, health);

    if (health <= 0) {
      health = 0;
      System.out.printf("%s: Player knocked out%n", name);
    }
  }

  public int remainingHealth() {
    return health;
  }

  public String getWeapon() {
    return weapon;
  }
}
