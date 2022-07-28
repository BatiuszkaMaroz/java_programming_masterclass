package V2_Encapsulation;

public class Player {
  public String name;
  public int health;
  public String weapon;

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
}
