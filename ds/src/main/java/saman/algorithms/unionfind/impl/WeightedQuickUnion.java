package saman.algorithms.unionfind.impl;

/**
 * This is an enhancement over QuickUnion.
 * Each time a union operation is done, the smaller tree is added to the larger tree.
 * Thus the size of the tree grows slowly resulting in quicker find operation.
 * @param <T> Type of the elements to be operated on
 */
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
