package V4_Inheritance2;

public class HealthyBurgerFactory extends BurgerFactory {
  HealthyBurger[] burgers = new HealthyBurger[10];

  @Override
  public HealthyBurger getBurger() {
    return burgers[0];
  }
}
