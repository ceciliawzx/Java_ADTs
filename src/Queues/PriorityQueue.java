package queues;

public class PriorityQueue<E> {

  private int size;
  private Node<E> first;
  private Node<E> last;

  public PriorityQueue() {
    size = 0;
    first = last = null;
  }

  public void enqueue(E element, Comparable priority) {
    final Node<E> newNode = new Node<>(element, priority);
    if (first == null || priority.compareTo(first.getPriority()) < 0) {
      newNode.setNext(first);
      first = newNode;
      if (size == 0) {
        last = first;
      }
    } else {
      Node<E> cursor = first;
      while (cursor.getNext() != null && priority.compareTo(cursor.getNext().getPriority()) > 0) {
        cursor = cursor.getNext();
      }
      newNode.setNext(cursor.getNext());
      if (cursor.getNext() == null) {
        last = newNode;
      }
      cursor.setNext(newNode);
    }
    size++;
  }

  public E dequeue() {
    if (size == 0) {
      return null;
    }
    E firstValue = first.getElement();
    first = first.getNext();
    if (--size == 0) {
      last = null;
    }
    return firstValue;
  }

  public E getFirst() {
    return (size == 0)? null : first.getElement();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private static class Node<E> {

    private E element;
    private final Comparable priority;
    private Node<E> next;

    public Node(E element, Node<E> next, Comparable priority) {
      this.element = element;
      this.next = next;
      this.priority = priority;
    }

    public Node(E element, Comparable priority) {
      this(element, null, priority);
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

    public Comparable getPriority() {
      return priority;
    }
  }
}
