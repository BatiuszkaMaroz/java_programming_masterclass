package challenges.C1_Bank;

import java.util.ArrayList;

public class Bank {
  private String name;
  private ArrayList<Branch> branches;

  public Bank(String name) {
    this.name = name;
    branches = new ArrayList<Branch>();
  }

  public boolean addBranch(String branchName) {
    if (findBranch(branchName) != null)
      return false;

    branches.add(new Branch(branchName));
    return true;
  }

  private Branch findBranch(String branchName) {
    for (int i = 0; i < branches.size(); i++)
      if (branches.get(i).getName().equals(branchName))
        return branches.get(i);

    return null;
  }

  public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
    Branch branch = findBranch(branchName);
    if (branch == null)
      return false;

    return branch.newCustomer(customerName, initialTransaction);
  }

  public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
    Branch branch = findBranch(branchName);
    if (branch == null)
      return false;

    return branch.addCustomerTransaction(customerName, transaction);
  }

  public boolean listCustomers(String branchName, boolean showTransactions) {
    Branch branch = findBranch(branchName);
    if (branch == null)
      return false;

    System.out.printf("Customer details for branch %s\n", branch.getName());

    ArrayList<Customer> customers = branch.getCustomers();
    for (int i = 0; i < customers.size(); i++) {
      Customer customer = customers.get(i);
      System.out.printf("Customer: %s[%d]\n", customer.getName(), i + 1);

      if (showTransactions) {
        System.out.println("Transactions");
        ArrayList<Double> transactions = customer.getTransactions();
        for (int j = 0; j < transactions.size(); j++)
          System.out.printf("[%d]  Amount %.2f\n", j + 1, transactions.get(j));
      }
    }

    return true;
  }
}
