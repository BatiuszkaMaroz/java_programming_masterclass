package com.dawidprajzner.V2_Encapsulation;

public class Main {
  public static void main(String[] args) {
    /*
     * without encapsulation
     * - there is no field validation
     * - some fields can be missed while constructing object
     * and setting fields manually
     * - inconsistency in usage, there are many ways to change value of field
     */

    Player p1 = new Player();

    p1.name = "David Wallace";
    p1.health = 100;
    p1.weapon = "Guardian Shield";

    p1.loseHealth(50);

    p1.health = 100;
    p1.loseHealth(50);

    /*
     * encapsulation solves all above problems
     */

    EnchantedPlayer ep1 = new EnchantedPlayer("William Wallace", 100, "Santander");
    ep1.loseHealth(50);
    ep1.loseHealth(50);
  }
}
