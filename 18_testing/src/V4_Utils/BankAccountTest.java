package V4_Utils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {
  private BankAccount acc;

  private String firstName = "Alfredo";
  private String secondName = "Vita";
  private double initBalance = 1000.0;

  /* ================================================== */

  @BeforeClass
  public static void beforeAll() {
    System.out.println("beforeAll() but static");
  }

  @AfterClass
  public static void afterAll() {
    System.out.println("afterAll() but static");
  }

  @Before
  public void beforeEach() {
    System.out.println("beforeEach()");
    acc = new BankAccount(firstName, secondName, initBalance);
  }

  @After
  public void afterEach() {
    System.out.println("afterEach()");
  }

  /* ================================================== */

  @Test
  public void testDeposit() {
    double balance = acc.deposit(0.5, true);
    assertEquals(balance, 1000.5, 0);
  }

  @Test
  public void testWithdraw() {
    double balance = acc.withdraw(1000, true);
    assertEquals(balance, 0, 0);
  }

  @Test
  public void testGetBalance() {
    assertEquals(acc.getBalance(), 1000, 0);
  }

  @Test
  public void testGetBalance_deposit() {
    acc.deposit(1000, true);
    assertEquals(acc.getBalance(), 2000, 0);
  }

  @Test
  public void testGetBalance_withdraw() {
    acc.withdraw(1000, true);
    assertEquals(acc.getBalance(), 0, 0);
  }
}
