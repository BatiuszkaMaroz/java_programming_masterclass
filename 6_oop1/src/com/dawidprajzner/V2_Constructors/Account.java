package com.dawidprajzner.V2_Constructors;

public class Account {
  private String number;
  private double balance;
  private String name;
  private String email;
  private String phone;

  /*
   * (good practice)
   * having main constructor that other constructors call
   */
  public Account(String number, double balance, String name, String email, String phone) {
    /*
     * setters shouldn't be called in constructor because of inheritance issues
     */

    this.number = number;
    this.balance = balance;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  /*
   * this(...) is another constructor call
   * and must be the first statement in constructor body
   */
  public Account() {
    // System.out.println("Empty constructor called!"); // will throw error
    this("000-000", 0, "-", "-", "-");
    System.out.println("Empty constructor called!");
  }

  public Account(String name, String email, String phone) {
    this("000-000", 0, name, email, phone);
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return balance;
  }

  public String getEmail() {
    return email;
  }

  public String getNumber() {
    return number;
  }

  public String getPhone() {
    return phone;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println(String.format("Deposit of %.2f made. New balance is %.2f.", amount, balance));
  }

  public void withdrawal(double amount) {
    if (balance - amount < 0)
      System.err.println("Insufficient balance for withdrawal.");
    else {
      balance -= amount;
      System.out.println(String.format("Withdrawal of %.2f made. New balance is %.2f.", amount, balance));
    }
  }
}
