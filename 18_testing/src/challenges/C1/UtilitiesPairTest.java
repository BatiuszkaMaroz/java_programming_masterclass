package challenges.C1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UtilitiesPairTest {
  private Utilities u;

  private String expected;
  private String source;

  public UtilitiesPairTest(String expected, String source) {
    this.expected = expected;
    this.source = source;
  }

  /* ================================================== */

  @Parameterized.Parameters
  public static Collection<Object[]> testConditions() {
    return Arrays.asList(new Object[][] {
        { "ABCDE", "ABBBCCDDEEEEEE" },
        { "ABCDE", "ABCDE" },
        { "ABCDE", "AAABBBCCCDDDEEE" },
        { "ABCDE", "AAAAAAAAAAAAAABCDDDDDDDE" },
        { "ABCDE", "AABBCCDDEEEEEEEEEEE" },
    });
  }

  @Before
  public void init() {
    u = new Utilities();
  }

  /* ================================================== */

  @Test
  public void testRemovePairs() {
    assertEquals(expected, u.removePairs(source));
  }
}
