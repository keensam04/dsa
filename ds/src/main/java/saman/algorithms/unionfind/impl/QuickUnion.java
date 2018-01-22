package saman.algorithms.unionfind.impl;

import saman.algorithms.unionfind.UnionFind;

public class QuickUnion<T extends Comparable> implements UnionFind<T> {

    protected final IndexedElement[] array;

    public QuickUnion(T[] array) {
        this.array = new IndexedElement[array.length];
        for (int i=0; i<array.length; i++) {
            this.array[i] = new IndexedElement<T>(array[i], i);
        }
    }

    @Override
    public void union(int index1, int index2) {
        IndexedElement element1 = root(index1);
        IndexedElement element2 = root(index2);
        element1.root = element2.root;
    }

    @Override
    public boolean isConnected(int index1, int index2) {
        return root(index1).element.compareTo(root(index1).element) == 0;
    }

    protected IndexedElement root(int index) {
        while (index != array[index].root)
            index = array[index].root;
        return array[index];
    }

    protected class IndexedElement<T extends Comparable> {

        final T element;
        int root;
        int size = 1;

        private IndexedElement(T element, int index) {
            this.element = element;
            this.root = index;
        }

    }
}
