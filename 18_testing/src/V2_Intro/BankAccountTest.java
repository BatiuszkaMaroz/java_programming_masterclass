package V2_Intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountTest {
  @Test
  public void testDeposit() {
    BankAccount acc = new BankAccount("John", "Doe", 20);

    /*
     * While comparing floating-point values we have to pass delta argument.
     * Delta is acceptable difference while comparing (because floating-point
     * numbers aren't perfect).
     */
    double balance = acc.deposit(1.15, true);
    assertEquals(balance, 21.15, 0);
  }

  @Test
  public void testWithdraw() {
    BankAccount acc = new BankAccount("John", "Doe", 20);

    double balance = acc.withdraw(20, true);
    assertEquals(balance, 0, 0);
  }

  @Test
  public void testGetBalance() {
    BankAccount acc = new BankAccount("John", "Doe", 20);

    assertEquals(acc.getBalance(), 20, 0);
  }

  @Test
  public void testGetBalance_deposit() {
    BankAccount acc = new BankAccount("John", "Doe", 20);

    acc.deposit(20, true);
    assertEquals(acc.getBalance(), 40, 0);
  }

  @Test
  public void testGetBalance_withdraw() {
    BankAccount acc = new BankAccount("John", "Doe", 20);

    acc.withdraw(20, true);
    assertEquals(acc.getBalance(), 0, 0);
  }
}
