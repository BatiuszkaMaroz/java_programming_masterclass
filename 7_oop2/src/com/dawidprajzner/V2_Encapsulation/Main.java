package com.dawidprajzner.V2_Encapsulation;

public class Main {
  public static void main(String[] args) {
    Player p1 = new Player();

    p1.name = "Wallace";
    p1.health = 20;
    p1.weapon = "Sword";

    p1.loseHealth(10);
    System.out.printf("Remaining health = %d%n", p1.remainingHealth());

    p1.loseHealth(10);
    System.out.printf("Remaining health = %d%n", p1.remainingHealth());
  }
}
