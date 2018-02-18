import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CircularSuffixArrayTest {

  @Test
  public void testEasyPath() {
    String str = "ABRACADABRA!";

    CircularSuffixArray cfa = new CircularSuffixArray(str);
/*
 *  i       Original Suffixes           Sorted Suffixes         index[i]
--    -----------------------     -----------------------    --------
 0    A B R A C A D A B R A !     ! A B R A C A D A B R A    11
 1    B R A C A D A B R A ! A     A ! A B R A C A D A B R    10
 2    R A C A D A B R A ! A B     A B R A ! A B R A C A D    7
 3    A C A D A B R A ! A B R     A B R A C A D A B R A !    0
 4    C A D A B R A ! A B R A     A C A D A B R A ! A B R    3
 5    A D A B R A ! A B R A C     A D A B R A ! A B R A C    5
 6    D A B R A ! A B R A C A     B R A ! A B R A C A D A    8
 7    A B R A ! A B R A C A D     B R A C A D A B R A ! A    1
 8    B R A ! A B R A C A D A     C A D A B R A ! A B R A    4
 9    R A ! A B R A C A D A B     D A B R A ! A B R A C A    6
10    A ! A B R A C A D A B R     R A ! A B R A C A D A B    9
11    ! A B R A C A D A B R A     R A C A D A B R A ! A B    2

 */
    assertEquals(0, cfa.index(3));
    assertEquals(7, cfa.index(2));
    assertEquals(2, cfa.index(11));
  }

}
