package stacks;

import java.util.Arrays;

public class ArrayBasedStack<E> implements StackInterface<E> {

    private final static int DEFAULT_MAX_SIZE = 100;

    private int top;
    private E[] elements;

    public ArrayBasedStack(int initialSize) {
        elements = (E[]) new Object[initialSize];
        top = -1;
    }

    public ArrayBasedStack() {
        this(DEFAULT_MAX_SIZE);
    }

    @Override
    public void push(E element) {
        checkEnoughSpace();
        elements[++top] = element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E res = elements[top];
        elements[top] = null;
        top--;
        return res;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    private void checkEnoughSpace() {
        if (top >= elements.length - 1) {
            throw new IllegalArgumentException("The stack is full");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
