package saman.util.adt.linear.linkedlist;

/**
 * Created by I311125 on 7/28/2017.
 */
public interface LinkedList<T> {

    enum POSITION { HEAD, TAIL };

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    Node<T> head();

    T get(final int index);

    default void insert(final T element) {
        insertAt(element, POSITION.HEAD);
    }

    void insertAt(final T element, final POSITION position);

    void insertAt(final T element, final int index);

    T deleteAt(final POSITION position);

    T deleteAt(final int index);

}
