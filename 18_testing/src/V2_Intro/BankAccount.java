package V2_Intro;

public class BankAccount {
  private String firstName;
  private String secondName;
  private double balance;

  public BankAccount(String firstName, String secondName, double balance) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.balance = balance;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public double getBalance() {
    return balance;
  }

  public double deposit(double amount, boolean branch) {
    balance += amount;
    return balance;
  }

  public double withdraw(double amount, boolean branch) {
    balance -= amount;
    return balance;
  }
}
