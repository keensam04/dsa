package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;

public class SelectionSort<E extends Comparable> implements Sort<E> {

    @Override
    public void apply(E[] elements, Order order) {
        for(int index = 0; index < elements.length; index++) {
            for(int subIndex = (index+1); subIndex < elements.length; subIndex++) {
                if (order.equals(Order.ASC) ? elements[subIndex].compareTo(elements[index]) < 0 : elements[subIndex].compareTo(elements[index]) > 0) {
                    E temp = elements[index];
                    elements[index] = elements[subIndex];
                    elements[subIndex] = temp;
                }
            }
        }
    }
}
