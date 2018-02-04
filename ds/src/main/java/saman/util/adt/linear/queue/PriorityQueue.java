package saman.util.adt.linear.queue;

import saman.util.adt.linear.heap.BinaryHeap;

public class PriorityQueue<T extends Comparable> implements Queue<T> {

    private final BinaryHeap<T> heap = new BinaryHeap<T>();

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(T element) {
        heap.insert(element);
    }

    @Override
    public T dequeue() {
        return heap.removeRoot();
    }
}
