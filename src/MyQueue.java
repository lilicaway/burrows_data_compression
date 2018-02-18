import java.util.NoSuchElementException;

public class MyQueue {
  private final int[] numbers;
  private int queueIndex = 0;
  private int dequeueIndex = 0;

  public MyQueue(int size) {
    numbers = new int[size];
  }

  void enqueue(int number) {
    numbers[queueIndex++] = number;
  }

  int dequeue() {
    if (dequeueIndex >= queueIndex) {
      throw new NoSuchElementException();
    }
    return numbers[dequeueIndex++];
  }
}
