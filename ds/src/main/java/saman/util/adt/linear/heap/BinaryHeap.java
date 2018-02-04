package saman.util.adt.linear.heap;

import saman.util.adt.linear.array.DynamicArray;

import static saman.util.BinaryOperations.less;
import static saman.util.BinaryOperations.swap;

public class BinaryHeap<T extends Comparable> {

    private final DynamicArray<T> heap;


    public BinaryHeap() {
        this(8);
    }

    public BinaryHeap(int initialSize) {
        heap = new DynamicArray<>(initialSize);
        heap.add(null);
    }

    public void insert(T item) {
        heap.add(item);
        swim(heap.size()-1);
    }

    private void swim(int k) {
        while (k > 1 && heap.compare(k/2, k) < 0) {
            heap.swap(k/2, k);
            k = k/2;
        }
    }

    public T removeRoot() {
        if (size() > 0) {
            T root = heap.get(1);
            heap.swap(1, heap.size()-1);
            heap.removeLast();
            sink(1);
            return root;
        }
        throw new UnsupportedOperationException("Cannot perform this operation on empty heap");
    }

    private void sink(int k) {
        while (2*k <= heap.size()) {
            int j = 2*k;
            if ((j+1) < heap.size() && heap.compare(j, j+1) < 0)
                j++;
            if (j >= heap.size() || heap.compare(k, j)>0)
                break;
            heap.swap(k, j);
            k = j;
        }
    }

    public int size() {
        return heap.size()-1;
    }
}
