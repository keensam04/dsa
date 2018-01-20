package saman.util.adt.linear.queue;

public interface Queue<T> {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();

    void enqueue(T element) throws QueueOverflowException;

    T dequeue() throws QueueOverflowException;
}
