package Lists;

public class selfOrderedList<E extends Comparable<E>> implements selfList<E> {

  private Node<E> head;
  private int size;

  @Override
  public void add(E element) {
    Node<E> newNode = new Node<>(element);
    if (head == null || element.compareTo(head.getElement()) < 0) {
      newNode.setNext(head);
      head = newNode;
    } else {
      Node<E> cursor = head;
      while (cursor.getNext() != null && element.compareTo(cursor.getNext().getElement()) > 0) {
        cursor = cursor.getNext();
      }
      newNode.setNext(cursor.getNext());
      cursor.setNext(newNode);
    }
    size++;
  }

  @Override
  public void add(E element, int position) {
    // unsupported;
  }

  @Override
  public E get(int position) {
    if (position < 0 || position >= size) {
      throw new IndexOutOfBoundsException("index out of range.");
    }
    if (position == 0) {
      return head.getElement();
    } else {
      Node<E> cursor = head;
      for (int i = 0; i < position; i++) {
        cursor = cursor.getNext();
      }
      return cursor.getElement();
    }

  }

  @Override
  public E remove(int position) {
    if (position < 0 || position >= size) {
      throw new IndexOutOfBoundsException();
    }
    E res = get(position);
    if (position == 0) {
      head = head.getNext();
    } else {
      Node<E> cursor = head;
      for (int i = 0; i < position - 1; i++) {
        cursor = cursor.getNext();
      }
      cursor.setNext(cursor.getNext().getNext());
    }
    size--;
    return res;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
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

    public void setElement(E element) {
      this.element = element;
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }
  }
}
