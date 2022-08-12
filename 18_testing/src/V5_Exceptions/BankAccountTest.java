package V5_Exceptions;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
  private BankAccount acc;

  private String firstName = "Alfredo";
  private String secondName = "Vita";
  private double initBalance = 1000.0;

  /* ================================================== */

  @Before
  public void beforeEach() {
    acc = new BankAccount(firstName, secondName, initBalance);
  }

  /* ================================================== */

  @Test
  public void testWithdraw_ranched() {
    acc.withdraw(500.01, true);
  }

  /*
   * Test for exception throw old way.
   */

  @Test
  public void testWithdraw_unbranched_old() {
    try {
      acc.withdraw(500.01, false);
      fail("Error not thrown.");
    } catch (IllegalArgumentException e) {
      //
    }
  }

  /*
   * Test for exception throw new way.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testWithdraw_unbranched_new() {
    acc.withdraw(500.01, false);
  }
}
