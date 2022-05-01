package queues;

public class ListBasedQueue<E> implements QueueInterface<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public ListBasedQueue() {
        this.size = 0;
        first = last = null;
    }

    @Override
    public void enqueue(E element) {
        Node<E> previousLast = last;
        last = new Node<>(element);
        if (size++ == 0) {
            first = last;
        } else {
            previousLast.setNext(last);
        }
    }

    @Override
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

    @Override
    public E getFirst() {
        return (size == 0)? null : first.getElement();
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
