package V4_Inheritance2;

public class BurgerFactory {
  Burger[] burgers = new Burger[10];

  public Burger getBurger() {
    return burgers[0];
  }
}
