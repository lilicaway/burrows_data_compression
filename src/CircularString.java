
public class CircularString implements Comparable<CircularString> {

  private final String original;
  private final int offset;

  public CircularString(String original, int offset) {
    this.original = original;
    this.offset = offset;

  }

  public int getOffset() {
    return offset;
  }

  public int length() {
    return original.length();
  }

  public char charAt(int i) {
    return original.charAt((i + offset) % length());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(length());
    for (int i = 0; i < length(); i++) {
      sb.append(charAt(i));
    }
    return sb.toString();
  }

  @Override
  public int compareTo(CircularString other) {
    int i = 0;
    boolean same = true;

    while (i < length() && same) {
      if (charAt(i) < other.charAt(i)) {
        return -1;
      } else if (charAt(i) > other.charAt(i)) {
        return 1;
      }
      same = (charAt(i) == other.charAt(i));
      i++;
    }
    if (length() < other.length()) {
      return -1;
    } else if (length() > other.length()) {
      return 1;
    } else {
      return 0;
    }
  }
}
