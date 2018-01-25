package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;
import saman.util.BinaryOperations;

import java.util.Comparator;

public class SelectionSort<E> implements Sort<E> {

    @Override
    public void apply(E[] elements, Order order, Comparator comparator) {
        for(int index = 0; index < elements.length; index++) {
            for(int subIndex = (index+1); subIndex < elements.length; subIndex++) {
                if (order.equals(Order.ASC) ? comparator.compare(elements[subIndex], elements[index]) < 0 : comparator.compare(elements[subIndex], elements[index]) > 0) {
                    BinaryOperations.swap(elements, index, subIndex);
                }
            }
        }
    }
}
