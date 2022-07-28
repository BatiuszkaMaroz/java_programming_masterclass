package challenges.C4_BillBurger;

public class HealthyBurger extends Hamburger {
  private String healthyExtra1Name;
  private double healthyExtra1Price;
  private String healthyExtra2Name;
  private double healthyExtra2Price;

  public HealthyBurger(String meat, double price) {
    super("Healthy hamburger", meat, price, "Brown rye roll");
  }

  public void addHealthyAddition1(String name, double price) {
    healthyExtra1Name = name;
    healthyExtra1Price = price;
  }

  public void addHealthyAddition2(String name, double price) {
    healthyExtra2Name = name;
    healthyExtra2Price = price;
  }

  @Override
  public double itemizeHamburger() {
    return super.itemizeHamburger() + healthyExtra1Price + healthyExtra2Price;
  }
}
