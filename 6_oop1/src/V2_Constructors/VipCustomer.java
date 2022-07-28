package V2_Constructors;

public class VipCustomer {
  private String name;
  private String email;
  private double limit;

  VipCustomer(String name, String email, double limit) {
    this.name = name;
    this.email = email;
    this.limit = limit;
  }

  VipCustomer(String name, String email) {
    this(name, email, 0);
  }

  VipCustomer() {
    this("-", "-", 0);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public double getLimit() {
    return limit;
  }
}
