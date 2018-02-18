import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CircularStringTest {
  private final String original = "ABRACADABRA!";

  @Test
  public void testOffset0() {
      int offset = 0;
      CircularString circularString = new CircularString(original, offset);
      assertEquals(12, circularString.length());
      int i = 0;
      assertEquals('A', circularString.charAt(i++));
      assertEquals('B', circularString.charAt(i++));
      assertEquals('R', circularString.charAt(i++));
      assertEquals('A', circularString.charAt(i++));
      assertEquals('C', circularString.charAt(i++));
      assertEquals('A', circularString.charAt(i++));
      assertEquals('D', circularString.charAt(i++));
      assertEquals('A', circularString.charAt(i++));
      assertEquals('B', circularString.charAt(i++));
      assertEquals('R', circularString.charAt(i++));
      assertEquals('A', circularString.charAt(i++));
      assertEquals('!', circularString.charAt(i++));
      assertEquals(circularString.length(), i);
    assertEquals("ABRACADABRA!", circularString.toString());
  }

  @Test
  public void testOffset1() {
    int offset = 1;
    CircularString circularString = new CircularString(original, offset);
    assertEquals(12, circularString.length());
    int i = 0;
    assertEquals('B', circularString.charAt(i++));
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('C', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('D', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('B', circularString.charAt(i++));
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('!', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals(circularString.length(), i);
    assertEquals("BRACADABRA!A", circularString.toString());
  }

  @Test
  public void testOffset2() {
    int offset = 2;
    CircularString circularString = new CircularString(original, offset);
    assertEquals(12, circularString.length());
    int i = 0;
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('C', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('D', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('B', circularString.charAt(i++));
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('!', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('B', circularString.charAt(i++));
    assertEquals(circularString.length(), i);
  }

  @Test
  public void testOffset11() {
    int offset = 11;
    CircularString circularString = new CircularString(original, offset);
    assertEquals(12, circularString.length());
    int i = 0;
    assertEquals('!', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('B', circularString.charAt(i++));
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('C', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('D', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals('B', circularString.charAt(i++));
    assertEquals('R', circularString.charAt(i++));
    assertEquals('A', circularString.charAt(i++));
    assertEquals(circularString.length(), i);
  }

  @Test
  public void testCompareLessThan() throws Exception {
    CircularString orig = new CircularString("ABC", 0);
    CircularString other = new CircularString("ABC", 1);

    assertEquals(-1, orig.compareTo(other));
  }

  @Test
  public void testBiggerThan() throws Exception {
    CircularString orig = new CircularString("ABC", 1);
    CircularString other = new CircularString("ABC", 0);

    assertEquals(1, orig.compareTo(other));
  }

  public void testAlmostEqualButLengthIsLess() throws Exception {
    CircularString orig = new CircularString("ABC", 0);
    CircularString other = new CircularString("DABC", 1);

    assertEquals(-1, orig.compareTo(other));
  }

  public void testAlmostEqualButLengthIsLonger() throws Exception {
    CircularString orig = new CircularString("DABC", 1);
    CircularString other = new CircularString("ABC", 0);

    assertEquals(-1, orig.compareTo(other));
  }

  @Test
  public void testCompareToEquals() throws Exception {
    CircularString orig = new CircularString("BCA", 2);
    CircularString other = new CircularString("ABC", 0);

    assertEquals(0, orig.compareTo(other));

    orig = new CircularString("CAB", 1);
    other = new CircularString("ABC", 0);

    assertEquals(0, orig.compareTo(other));

    orig = new CircularString("ABC", 0);
    other = new CircularString("ABC", 0);

    assertEquals(0, orig.compareTo(other));

  }
}
