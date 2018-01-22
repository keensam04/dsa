package saman.algorithms.unionfind;

public interface UnionFind<T extends Comparable> {

    /**
     * connects the two elements at indices index1 and index2
     * @param index1 index of first element
     * @param index2 index of second element
     */
    void union(int index1, int index2);

    /**
     * checks if the elements at given indices are connected
     * @param index1 index of first element
     * @param index2 index of second element
     * @return true if the elements are connected and false if the elements are not connected
     */
    boolean isConnected(int index1, int index2);

}
