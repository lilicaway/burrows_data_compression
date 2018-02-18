import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

  // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
  public static void transform() {
    // read string from std input
    String input = BinaryStdIn.readString();
    CircularSuffixArray cfa = new CircularSuffixArray(input);
    int i = 0;
    for (i = 0; i < input.length(); i++) {
      if (cfa.index(i) == 0) {
        BinaryStdOut.write(i);
        break;
      }
    }
    // Get the last char column
    for (i = 0; i < input.length(); i++) {
      int index = cfa.index(i);
      if (index == 0) {
        BinaryStdOut.write(input.charAt(input.length() - 1));
        continue;
      }
      BinaryStdOut.write(input.charAt(index - 1));
    }

    // BinaryStdOut must be closed
    // BinaryStdIn.close();
    BinaryStdOut.close();
  }

  // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard
  // output
  public static void inverseTransform() {
    int first = BinaryStdIn.readInt();
    String chars = BinaryStdIn.readString();
    char[] t = chars.toCharArray();
    int[] histogram = createHistogram(t);
    // BinaryStdIn.close();

    // Build next[] array

    MyQueue[] pos = new MyQueue[256];
    for (int i = 0; i < histogram.length; i++) {
      if (histogram[i] > 0) {
        pos[i] = new MyQueue(histogram[i]);
      }
    }
    // Map<Character, Queue<Integer>> pos = new HashMap<>();
    for (int i = 0; i < t.length; i++) {
      pos[t[i]].enqueue(i);
      // if (pos.containsKey(t[i])) {
      // pos.get(t[i]).enqueue(i);
      // } else {
      // pos.put(t[i], new Queue<Integer>());
      // pos.get(t[i]).enqueue(i);
      // }
    }

    // Tengo first y tengo t, tambien puedo conseguir la primer columna
    // Arrays.sort(t);
    sortAsExtendedAscii(t, histogram);
    int[] next = new int[t.length];
    // go consistently through sorted firstChars array
    for (int i = 0; i < t.length; i++) {
      // next[i] = pos.get(t[i]).dequeue();
      next[i] = pos[t[i]].dequeue();
    }

    // Build the original text
    for (int i = 0, curRow = first; i < t.length; i++, curRow = next[curRow]) {
      BinaryStdOut.write(t[curRow]);
    }

    BinaryStdOut.close();
  }

  private static void sortAsExtendedAscii(char[] output, int[] histogram) {
    // First we create an histogram of each character

    int currentOutPos = 0;
    for (int i = 0; i < histogram.length; i++) {
      for (int j = 0; j < histogram[i]; j++) {
        output[currentOutPos++] = (char) i;
      }
    }
    if (currentOutPos != output.length) {
      throw new IllegalArgumentException("output array has unexpected length. output.length:"
          + output.length + ", currentOutPos: " + currentOutPos);
    }
  }

  private static int[] createHistogram(char[] extendedAsciiArray) {
    int[] histogram = new int[256];
    for (char c : extendedAsciiArray) {
      histogram[c]++;
    }
    return histogram;
  }

  /**
   * if args[0] is '-', apply Burrows-Wheeler transform. if args[0] is '+', apply Burrows-Wheeler
   * inverse transform
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 1)
      throw new IllegalArgumentException("Expected + or -\n");
    else if (args[0].equals("-"))
      transform();
    else if (args[0].equals("+"))
      inverseTransform();
    else {
      String msg = "Unknown argument: " + args[0] + "\n";
      throw new IllegalArgumentException(msg);
    }
  }
}
