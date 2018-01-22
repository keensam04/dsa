package saman.algorithms.unionfind.impl;

/**
 * This is an enhancement on WeightedQuickUnion.
 * Each time a union/find operation is done the tree structure gets optimised.
 * Thus the next query takes either similar or less time.
 * @param <T> Type of the elements to be operated on
 */
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
