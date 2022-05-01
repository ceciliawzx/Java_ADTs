package Lists;

public class selfLinkedList<E> implements selfList<E> {

  private Node<E> head;
  private int size;

  @Override
  public void add(final E element) {
    if (head == null) {
      head = new Node<>(element);
    } else {
      Node<E> cursor = head;
      Node<E> newNode = new Node<>(element);
      while (cursor.getNext() != null) {
        cursor = cursor.getNext();
      }
      cursor.setNext(newNode);
    }
    size++;
  }

  @Override
  public void add(E element, int position) {
    if (position < 0 || position > size) {
      throw new IndexOutOfBoundsException("index out of range.");
    }
    if (position == 0) {
      head = new Node<>(element, head);
    } else {
      Node<E> cursor = head;
      for (int i = 0; i < position - 1; i++) {
        cursor = cursor.getNext();
      }
      Node<E> newNode = new Node<>(element, cursor.getNext());
      cursor.setNext(newNode);
    }
    size++;
  }

  @Override
  public E get(int position) {
    if (position < 0 || position > size) {
      throw new IndexOutOfBoundsException("index out of range.");
    }
    if (position == 0) {
        return head.getElement();
    }
    Node<E> cursor = head;
    for (int i = 0; i < position; i++) {
        cursor = cursor.getNext();
    }
    return cursor.getElement();
  }

  @Override
  public E remove(int position) {
    if (position < 0 || position > size) {
      throw new IndexOutOfBoundsException("index out of range.");
    }
    E oldValue = get(position);
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
    return oldValue;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

    @Override
    public String toString() {
        String res = "list: ";
        for (int i = 0; i < size; i++) {
            res += this.get(i) + " ";
        }
        res += "\nsize: " + size;
        return res;
    }

    private static class Node<E> {
    private E element;
    private Node<E> next;

    public Node(final E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }

    public Node(final E element) {
      this(element, null);
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setElement(E element) {
      this.element = element;
    }

    public E getElement() {
      return element;
    }
  }

  public static void main(String[] args) {
      selfList<Integer> list = new selfLinkedList<>();
      list.add(1);
      list.add(2);
      list.add(9);
      list.add(2);
      list.add(8);
    System.out.println(list);
    list.remove(0);
    System.out.println(list);
    list.add(9,4);
    System.out.println(list);
    list.add(19,4);
    System.out.println(list);
    System.out.println(list.get(5));
  }
}
