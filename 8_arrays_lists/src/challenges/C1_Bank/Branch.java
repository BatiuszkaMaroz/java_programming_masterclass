package challenges.C1_Bank;

import java.util.ArrayList;

public class Branch {
  private String name;
  private ArrayList<Customer> customers = new ArrayList<Customer>();

  public Branch(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Customer> getCustomers() {
    return customers;
  }

  public boolean newCustomer(String customerName, double initialTransaction) {
    if (findCustomer(customerName) != null)
      return false;

    customers.add(new Customer(customerName, initialTransaction));
    return true;
  }

  private Customer findCustomer(String customerName) {
    for (int i = 0; i < customers.size(); i++)
      if (customers.get(i).getName().equals(customerName))
        return customers.get(i);

    return null;
  }

  public boolean addCustomerTransaction(String customerName, double transaction) {
    Customer c = findCustomer(customerName);

    if (c == null)
      return false;

    c.addTransaction(transaction);
    return true;
  }
}
