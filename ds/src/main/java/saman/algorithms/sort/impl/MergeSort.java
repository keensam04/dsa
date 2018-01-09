package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;

import java.util.Arrays;

public class MergeSort<E extends Comparable> implements Sort<E> {

    /**
     *
     * @param elements the array to be sorted
     * @param order the order of sorting. allowed values are ASC or DESC
     */
    @Override
    public void apply(E[] elements, Order order) {
        sort(elements, 0, (elements.length - 1), order);
    }

    private void sort(E[] elements, int startIndex, int endIndex, Order order) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            sort(elements, startIndex, midIndex, order);
            sort(elements, (midIndex + 1), endIndex, order);
            merge(elements, startIndex, midIndex, endIndex, order);
        }
    }

    private void merge(E[] elements, int startIndex, int midIndex, int endIndex, Order order) {
        E[] leftArray = Arrays.copyOfRange(elements, startIndex, (midIndex + 1));
        E[] rightArray = Arrays.copyOfRange(elements, (midIndex + 1), (endIndex + 1));
        E[] leftOverArray = null;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int leftOverIndex = -1;
        int index = startIndex;
        for (; index <= endIndex; index++) {
            if (order.equals(Order.ASC) ? leftArray[leftArrayIndex].compareTo(rightArray[rightArrayIndex]) < 0 :
                    leftArray[leftArrayIndex].compareTo(rightArray[rightArrayIndex]) > 0) {
                elements[index] = leftArray[leftArrayIndex++];
                if (leftArrayIndex == leftArray.length) {
                    leftOverArray = rightArray;
                    leftOverIndex = rightArrayIndex;
                    index++;
                    break;
                }
            } else {
                elements[index] = rightArray[rightArrayIndex++];
                if (rightArrayIndex == rightArray.length) {
                    leftOverArray = leftArray;
                    leftOverIndex = leftArrayIndex;
                    index++;
                    break;
                }
            }
        }
        if (leftOverArray != null) {
            for (; index <= endIndex; index++) {
                elements[index] = leftOverArray[leftOverIndex++];
            }
        }
    }
}
