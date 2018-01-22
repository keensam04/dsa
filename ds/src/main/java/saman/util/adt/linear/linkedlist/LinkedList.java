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

    Node<T> tail();

    T get(final int index);

    default void insert(final T element) {
        insertAt(element, POSITION.HEAD);
    }

    default void insertAt(final T element, final POSITION position) {
        switch(position) {
            case HEAD:
                insertAt(element, 0);
                break;
            case TAIL:
                insertAt(element, size());
                break;
        }
    }

    void insertAt(final T element, final int index);

    default T deleteAt(final POSITION position) {
        switch(position) {
            case HEAD:
                return deleteAt(0);
            case TAIL:
                return deleteAt(size() - 1);
            default:
                throw new IllegalArgumentException("Position not allowed");
        }

    }

    T deleteAt(final int index);

}
