package saman.algorithms.unionfind.impl;

public class WeightedQuickUnion<T extends Comparable> extends QuickUnion<T> {


    public WeightedQuickUnion(T[] array) {
        super(array);
    }

    @Override
    public void union(int index1, int index2) {
        IndexedElement element1  = root(index1);
        IndexedElement element2  = root(index2);
        if (element1.root == element2.root)
            return;
        if (element1.size < element2.size) {
            element1.root = element2.root;
            element2.size += element1.size;
        } else {
            element2.root = element1.root;
            element1.size += element2.size;
        }
    }
}
