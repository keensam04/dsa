package saman.util.adt.linear.queue;

import saman.util.adt.linear.linkedlist.DoublyLinkedList;
import saman.util.adt.linear.linkedlist.LinkedList;
import saman.util.adt.linear.linkedlist.LinkedList.POSITION;

public class QueueImpl<T> implements Queue<T> {

    private final int capacity;
    private final LinkedList<T> linkedList = new DoublyLinkedList<>();

    public QueueImpl() {
        this(Integer.MAX_VALUE);
    }

    public QueueImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (isFull())
            throw new QueueOverflowException("The queue is already full");

        linkedList.insertAt(element, POSITION.TAIL);
    }

    @Override
    public T dequeue() throws QueueOverflowException {
        if (isEmpty())
            throw new QueueOverflowException("The queue is empty");

        return linkedList.deleteAt(POSITION.HEAD);
    }
}
