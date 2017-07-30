package saman.util.adt.linear.stack;

/**
 * Created by I311125 on 7/31/2017.
 */
public interface Stack<T> {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();

    void push(T element) throws StackOverflowException;

    T pop() throws StackOverflowException;

    T top() throws StackOverflowException;
}
