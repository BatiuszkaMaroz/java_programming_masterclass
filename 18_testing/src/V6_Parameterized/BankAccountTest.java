package V6_Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * Results of parameterized class run can be find under
 * "Test Explorer/18_testing/V6_Parameterized/BankAccountTest/"
 * there we have [0], [1], [2], [3], [4] ran test cases :D
 *
 * It's just extension not showing test pass on method directly but on whole
 * class. It's like testing against whole class not direct method.
 */
@RunWith(Parameterized.class)
public class BankAccountTest {

  private BankAccount acc;

  private String firstName = "Alfredo";
  private String secondName = "Vita";
  private double initBalance = 1000.00;

  private final double amount;
  private final boolean branch;
  private final double expected;

  /* ================================================== */

  @Parameterized.Parameters
  public static Collection<Object[]> testConditions() {
    return Arrays.asList(new Object[][] {
        { 100.00, true, 1100.00 },
        { 222.00, true, 1222.00 },
        { 300.00, true, 1300.00 },
        { 444.00, true, 1444.00 },
        { 325.14, true, 1325.14 },
    });
  }

  public BankAccountTest(double amount, boolean branch, double expected) {
    this.amount = amount;
    this.branch = branch;
    this.expected = expected;
  }

  /* ================================================== */

  @Before
  public void beforeEach() {
    acc = new BankAccount(firstName, secondName, initBalance);
  }

  /* ================================================== */

  @Test
  public void testDeposit() {
    double balance = acc.deposit(amount, branch);
    assertEquals(balance, expected, 0.000_000_1);
  }
}
