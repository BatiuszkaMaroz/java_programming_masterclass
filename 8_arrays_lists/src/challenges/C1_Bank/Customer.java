package challenges.C1_Bank;

import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Double> transactions = new ArrayList<Double>();

  public Customer(String name, double initialTransaction) {
    this.name = name;
    transactions.add(initialTransaction);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Double> getTransactions() {
    return transactions;
  }

  public void addTransaction(double transaction) {
    transactions.add(transaction);
  }
}
