package V4_Inheritance2;

public class HealthyBurger extends Burger {
  boolean vegan;

  public HealthyBurger(int kcal, boolean vegan) {
    super(kcal);
    this.vegan = vegan;
  }
}
