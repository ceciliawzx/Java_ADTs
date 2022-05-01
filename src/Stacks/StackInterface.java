package stacks;

public interface StackInterface<E> {

    public void push(E element);

    public E peek();

    public E pop();

    public boolean isEmpty();

    public int size();
}
