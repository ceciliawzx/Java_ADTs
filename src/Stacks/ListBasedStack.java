package stacks;

import queues.ListBasedQueue;

public class ListBasedStack<E> implements StackInterface<E> {

    private int size;
    private Node<E> top;

    @Override
    public void push(E element) {
        top = new Node<>(element, top);
        size++;
    }

    @Override
    public E peek() {
        return (isEmpty())? null : top.getElement();
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E topValue = top.getElement();
        top = top.getNext();
        size--;
        return topValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }
    }
}
