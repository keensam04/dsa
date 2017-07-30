package saman.util.adt.linear.stack;

import saman.util.adt.linear.linkedlist.LinkedList;
import saman.util.adt.linear.linkedlist.SinglyLinkedList;

/**
 * Created by I311125 on 7/31/2017.
 */
public class StackImpl<T> implements Stack<T> {

    private final int capacity;
    private final LinkedList<T> stack;

    public StackImpl() {
        this(Integer.MAX_VALUE);
    }

    public StackImpl(final int capacity) {
        this.capacity = capacity;
        stack = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isFull() {
        return stack.size() == capacity;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException("Stack is full");
        try {
            stack.insert(element);
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverflowException(e);
        }
    }

    @Override
    public T pop() throws StackOverflowException {
        try {
            return stack.deleteAt(LinkedList.POSITION.HEAD);
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverflowException(e);
        }
    }

    @Override
    public T top() throws StackOverflowException {
        try {
            return stack.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverflowException(e);
        }
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
