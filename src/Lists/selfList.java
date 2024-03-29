package Lists;

public interface selfList<E> {

  void add(E element);

  void add(E element, int position);

  E get(int position);

  E remove(int position);

  int size();

  boolean isEmpty();
}
