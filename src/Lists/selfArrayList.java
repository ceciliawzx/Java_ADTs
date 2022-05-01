package Lists;

import java.util.Arrays;
import java.util.stream.IntStream;

public class selfArrayList<E> implements selfList<E>{

    public static final int DEFAULT_INITIAL_SIZE = 100;
    private final int limit;
    private int size;
    private E[] elements;

    public selfArrayList(int initialSize) {
        this.elements = (E[]) new Object[initialSize];
        limit = initialSize;
        this.size = 0;
    }

    public selfArrayList() {
        this(DEFAULT_INITIAL_SIZE);
    }

    @Override
    public void add(E element) {
        if (size == limit) {
            System.out.println("limit exceeded, fail.");
        } else {
            elements[size] = element;
            size++;
        }
    }

    @Override
    public void add(E element, int position) {
        if (size >= limit) {
      System.out.println("limit exceeded, fail.");
      return;
        }
        if (position >= 0 && position <= size) {
            shiftArrayRight(position);
            elements[position] = element;
            size++;
        } else {
            throw new IllegalArgumentException("index out of range.");
        }
    }

    @Override
    public E get(int position) {
        if (position >= 0 && position < size) {
            return elements[position];
        }
        System.out.println("index out of range || no element in this position.");
        return null;
    }

  @Override
  public E remove(int position) {
    if (position >= 0 && position < size) {
        E oldElement = elements[position];
        shiftArrayLeft(position);
        size--;
        return oldElement;
    }
    System.out.println("index out of range || no element in this position.");
    return null;
        }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void shiftArrayLeft(int pos) {
        IntStream.range(pos, size).forEach(i -> {
            elements[i] = elements[i + 1];
        });
    }

    private void shiftArrayRight(int pos) {
        for (int i = size + 1; i > pos; i--) {
            elements[i] = elements[i - 1];
        }
    }

    @Override
    public String toString() {
        return "selfArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
