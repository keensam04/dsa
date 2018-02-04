package saman.util.adt.linear.array;

import saman.util.BinaryOperations;

public class DynamicArray<T> {

    private Object[] array;
    private int size = 0;

    public DynamicArray() {
        this(8);
    }

    public DynamicArray(int initialSize) {
        array = new Object[initialSize];
    }

    public T get(int index) {
        return (T)array[index];
    }

    public void add(T item) {
        array[size++] = item;
        if (size == array.length)
            copyArray(size*2);
    }

    public void removeLast() {
        if (size > 0) {
            array[--size] = null;
            if (size == array.length/4)
                copyArray(array.length/2);
        } else
            throw new UnsupportedOperationException("Cannot remove element from an empty array");
    }

    public int size() {
        return size;
    }

    int capacity() {
        return array.length;
    }

    private void copyArray(int newArrayLength) {
        Object[] temp = new Object[newArrayLength];
        for (int i=0; i<size; i++)
            temp[i] = array[i];
        array = temp;
    }

    public int compare(int index1, int index2) {
        if (get(index1) instanceof Comparable)
            return ((Comparable) get(index1)).compareTo(get(index2));
        else if (get(index1).equals(index2))
            return 0;
        else
            throw new UnsupportedOperationException("Objects do not implement comparable");
    }

    public void swap(int index1, int index2) {
        BinaryOperations.swap(array, index1, index2);
    }
}
