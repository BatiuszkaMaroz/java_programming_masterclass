package com.dawidprajzner.V2_Encapsulation;

public class Player {
  public String name;
  public int health;
  public String weapon;

  public void loseHealth(int damage) {
    health -= damage;

    if (health <= 0)
      System.out.println("Player knocked out");
  }

  public int remainingHealth() {
    return health;
  }
}
