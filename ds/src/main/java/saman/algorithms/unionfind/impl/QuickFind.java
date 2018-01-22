package saman.algorithms.unionfind.impl;

import saman.algorithms.unionfind.UnionFind;

public class QuickFind<T extends Comparable> implements UnionFind<T> {

    final T[] array;

    public QuickFind(T[] array) {
        this.array = array;
    }

    /**
     * O(n) = n
     * @param index1 index of first element
     * @param index2 index of second element
     */
    @Override
    public void union(int index1, int index2) {
        T element1 = array[index1];
        T element2 = array[index2];
        for (int i=0; i<array.length; i++) {
            if (array[i].compareTo(element2) == 0) array[i] = element1;
        }
    }

    /**
     * O(n) = 1
     * @param index1 index of first element
     * @param index2 index of second element
     * @return true if first element is equal to second element
     */
    @Override
    public boolean isConnected(int index1, int index2) {
        if (index1 < 0 || index1 >= array.length ||
                index2 < 0 || index2 >= array.length)
            throw new IllegalArgumentException("index1 and index2 should be within range [0," + array.length + ")");
        return array[index1].compareTo(array[index2]) == 0;
    }
}
