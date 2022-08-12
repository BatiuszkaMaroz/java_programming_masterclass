package V3_Asserts;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AssertsTest {
  @Test
  public void compairsion() {
    /*
     * Built-in assert gives few info, and its usage is not recommended.
     * It's better to use assertTrue or even better assertEquals.
     */

    int v1 = 10;
    int v2 = 10;

    assert (v1 == v2);
    assertTrue(v1 == v2);
    assertEquals(v1, v2);

    /*
     * We can test for inequality.
     */

    assertNotEquals(v1, v1 + 1);

    /*
     * We can provide custom on-error message.
     */

    assertEquals("Error", v1, v2);
  }

  @Test
  public void arrays() {
    /*
     * To compare values of array we have to use assertArrayEquals. Otherwise
     * references would be compared.
     */

    int[] arr1 = { 1, 2, 3 };
    int[] arr2 = { 1, 2, 3 };

    assertArrayEquals(arr1, arr2);
  }

  @Test
  public void nullability() {
    List<String> list1 = null;
    List<String> list2 = new ArrayList<>();

    assertNull(list1);
    assertNotNull(list2);
  }

  @Test
  public void references() {
    Object o1 = new Object();
    Object o2 = o1;
    Object o3 = new Object();

    assertSame(o1, o2);
    assertNotSame(o1, o3);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void that() {
    /*
     * Deprecated assertThat method.
     */

    assertThat("123", is("123"));
    assertThat("123", isA(String.class));
  }
}
