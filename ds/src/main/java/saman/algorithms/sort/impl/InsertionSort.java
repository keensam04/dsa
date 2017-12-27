package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;

public class InsertionSort<E extends Comparable> implements Sort<E> {

    @Override
    public void apply(E[] elements, Order order) {
        for (int index = 1; index < elements.length; index++) {
            E key = elements[index];
            int subIndex = index - 1;
            while (subIndex >= 0 && (order.equals(Order.ASC) ?
                    elements[subIndex].compareTo(key) > 0 : elements[subIndex].compareTo(key) < 0)) {
                elements[subIndex+1] = elements[subIndex];
                subIndex = subIndex - 1;
            }
            elements[subIndex+1] = key;
        }
    }
}
