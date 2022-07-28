package challenges.C4_BillBurger;

public class DeluxeBurger extends Hamburger {
  public DeluxeBurger() {
    super("Deluxe hamurger", "Sausage & Bacon", 19.10, "deluxe");
  }

  @Override
  public void addHamburgerAddition1(String name, double price) {
    System.out.println("Cannot not add additional items to a deluxe burger");
  }

  @Override
  public void addHamburgerAddition2(String name, double price) {
    System.out.println("Cannot not add additional items to a deluxe burger");
  }

  @Override
  public void addHamburgerAddition3(String name, double price) {
    System.out.println("Cannot not add additional items to a deluxe burger");
  }

  @Override
  public void addHamburgerAddition4(String name, double price) {
    System.out.println("Cannot not add additional items to a deluxe burger");
  }
}
