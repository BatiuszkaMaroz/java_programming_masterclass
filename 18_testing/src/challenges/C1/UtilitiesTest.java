package challenges.C1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {
  private Utilities u;

  @Before
  public void init() {
    u = new Utilities();
  }

  @Test
  public void testConverter() {
    assertEquals(300, u.converter(10, 5));
  }

  @Test(expected = ArithmeticException.class)
  public void testConverter_ZeroDiv() {
    u.converter(10, 0);
  }

  @Test
  public void testEveryNthChar() {
    assertArrayEquals(
        new char[] { 'h', 'e', 'l', 'l', 'o' },
        u.everyNthChar(new char[] { 'h', 'e', 'l', 'l', 'o' }, 1));

    assertArrayEquals(
        new char[] { 'h', 'e', 'l', 'l', 'o' },
        u.everyNthChar(new char[] { '_', 'h', '_', 'e', '_', 'l', '_', 'l', '_', 'o' }, 2));

    assertArrayEquals(
        new char[] {},
        u.everyNthChar(new char[] { 'h', 'e', 'l', 'l', 'o' }, 10));
  }

  @Test
  public void testNullIfOddLength() {
    assertNull(u.nullIfOddLength("abc"));
    assertNull(u.nullIfOddLength("abcde"));

    assertNotNull(u.nullIfOddLength("abcd"));
    assertNotNull(u.nullIfOddLength("abcdef"));
  }

  @Test
  public void testRemovePairs() {
    assertEquals("ABCDE", u.removePairs("ABBBCCDDEEEEEE"));
    assertEquals("ABCDE", u.removePairs("ABCDE"));
    assertEquals("ABCDE", u.removePairs("AAABBBCCCDDDEEE"));
  }
}
