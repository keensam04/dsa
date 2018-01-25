package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;
import saman.util.BinaryOperations;

import java.util.Comparator;

public class ShellSort<T> implements Sort<T> {

    /**
     * worst-case: O(n^(3/2))
     * @param elements
     * @param order
     */
    @Override
    public void apply(T[] elements, Order order, Comparator comparator) {
        int h = 1;
        while (h < elements.length/3)
            h = 3*h + 1;

        while (h >= 1) {
            for (int i=h; i<elements.length; i++) {
                for (int j=i; j>=h && compare(elements[j], elements[j-h], order, comparator); j-=h) {
                    BinaryOperations.swap(elements, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private boolean compare(T element1, T element2, Order order, Comparator comparator) {
        return order.equals(Order.ASC) ?
                comparator.compare(element1, element2) < 0 :
                comparator.compare(element1, element2) >= 0;
    }
}
