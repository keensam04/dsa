package saman.util.adt.linear.queue;

import saman.util.adt.linear.stack.Stack;
import saman.util.adt.linear.stack.StackImpl;
import saman.util.adt.linear.stack.StackOverflowException;

public class QueueUsing2Stacks<T> implements Queue<T> {

    private final int capacity;
    private final Stack<T> inbox;
    private final Stack<T> outbox;

    public QueueUsing2Stacks() {
        this(Integer.MAX_VALUE);
    }

    public QueueUsing2Stacks(int capacity) {
        this(capacity, new StackImpl(capacity), new StackImpl(capacity));
    }

    public QueueUsing2Stacks(int capacity, Stack inbox, Stack outbox) {
        this.capacity = capacity;
        this.inbox = inbox;
        this.outbox = outbox;
    }

    @Override
    public int size() {
        return (inbox.size() + outbox.size());
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        try {
            inbox.push(element);
        } catch (StackOverflowException e) {
            throw new QueueOverflowException(e);
        }
    }

    @Override
    public T dequeue() throws QueueOverflowException {
        try {
            if (outbox.isEmpty()) {
                while (!inbox.isEmpty())
                    outbox.push(inbox.pop());
            }
            if (outbox.isEmpty())
                throw new QueueOverflowException("Operation not allowed on emtpy queue");
            return outbox.pop();
        } catch (StackOverflowException e) {
            throw new QueueOverflowException(e);
        }
    }
}
