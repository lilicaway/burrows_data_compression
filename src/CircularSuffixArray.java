import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {

  private final int len;
  // private final List<CircularString> origList = new ArrayList<>();
  private final List<CircularString> orderedList = new ArrayList<>();

  // circular suffix array of s
  public CircularSuffixArray(String s) {
    if (s == null) {
      throw new IllegalArgumentException("String argument cant be null");
    }
    len = s.length();
    // buildSufixList(origList, s);
    buildSufixList(orderedList, s);
    getOrderedList();
  }

  // Would I need to implement 3wayString ord?
  private void getOrderedList() {

    Collections.sort(orderedList);
  }

  private void buildSufixList(List<CircularString> list, String s) {
    for (int i = 0; i < s.length(); i++) {
      list.add(new CircularString(s, i));
    }
  }

  // length of s
  public int length() {
    return len;
  }

  // returns index of ith sorted suffix
  public int index(int i) {
    if (i < 0 || i > orderedList.size() - 1) {
      throw new IllegalArgumentException("Index is out of range");
    }
    return orderedList.get(i).getOffset();
  }

  // unit testing (required)
  public static void main(String[] args) {
    int SCREEN_WIDTH = 80;
    String s = StdIn.readString();
    int n = s.length();
    int digits = (int) Math.log10(n) + 1;
    String fmt = "%" + (digits == 0 ? 1 : digits) + "d ";
    StdOut.printf("String length: %d\n", n);
    CircularSuffixArray csa = new CircularSuffixArray(s);
    for (int i = 0; i < n; i++) {
      StdOut.printf(fmt, i);
      for (int j = 0; j < (SCREEN_WIDTH - digits - 1) && j < n; j++) {
        char c = s.charAt((j + csa.index(i)) % n);
        if (c == '\n')
          c = ' ';
        StdOut.print(c);
      }
      StdOut.printf(fmt, csa.index(i));
      StdOut.println();
    }
  }

}
