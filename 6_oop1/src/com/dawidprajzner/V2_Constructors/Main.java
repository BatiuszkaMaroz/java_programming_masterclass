
package com.dawidprajzner.V2_Constructors;

public class Main {
  public static void main(String[] args) {
    Account bobAcc = new Account("123-456", 0, "Bob", "bob@bob.com", "111 222 333");

    bobAcc.deposit(90.5);
    bobAcc.withdrawal(100);

    bobAcc.deposit(10);
    bobAcc.withdrawal(100);

    Account unknownAcc = new Account();
    Account timAcc = new Account("Tim", "tim@bob.com", "123 456 789");
  }
}
