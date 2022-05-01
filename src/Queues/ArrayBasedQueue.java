package queues;

import java.util.Arrays;

public class ArrayBasedQueue<E> implements QueueInterface<E> {

  private static final int DEFAULT_MAX_SIZE = 100;

  private E[] elements;
  private int first;
  private int last;

  public ArrayBasedQueue(int limit) {
    elements = (E[]) new Object[limit];
    this.first = -1;
    this.last = -1;
  }

  public ArrayBasedQueue() {
    this(DEFAULT_MAX_SIZE);
  }

  @Override
  public void enqueue(E element) {
    checkIfFull();
    if (isEmpty()) {
      first++;
    }
    last = (last + 1) % elements.length;
    elements[last] = element;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      return null;
    }
    final E firstValue = elements[first];
    elements[first] = null;
    if (first == last) {
      first = last = -1;
    } else {
      first = (first + 1) % elements.length;
    }
    return firstValue;
  }

  @Override
  public E getFirst() {
    return isEmpty() ? null : elements[first];
  }

  @Override
  public int size() {
    if (first == -1 && last == -1) {
      return 0;
    }
    if (first <= last) {
      return last - first + 1;
    } else {
      return (elements.length - first) + (last + 1);
    }
  }

  private void checkIfFull() {
    if ((last + 1) % elements.length == first) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Queue: [");
    if (isEmpty()) {
      sb.append("empty");
    } else {
      for (int i = 0; i < size(); i++) {
        sb.append(elements[(first + i) % elements.length]).append(" ");
      }
    }
    sb.append("] - elements: ")
        .append(Arrays.toString(elements))
        .append(" - first: ")
        .append(first)
        .append(" - last: ")
        .append(last);
    return sb.toString();
  }
}
