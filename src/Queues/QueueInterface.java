package queues;

public interface QueueInterface<E> {

    public void enqueue(E element);

    public E dequeue();

    public E getFirst();

    public int size();

    default public boolean isEmpty() {
        return size() == 0;
    }

}
