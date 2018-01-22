package saman.algorithms.unionfind.impl;

public class PathCompressedWeightedQuickUnion<T extends Comparable> extends WeightedQuickUnion<T> {


    public PathCompressedWeightedQuickUnion(T[] array) {
        super(array);
    }

    @Override
    protected IndexedElement root(int index) {
        while (index != array[index].root) {
            array[index].root = array[array[index].root].root;
            index = array[index].root;
        }
        return array[index];
    }
}
