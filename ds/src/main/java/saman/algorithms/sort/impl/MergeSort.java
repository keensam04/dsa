package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;

import java.util.Arrays;

public class MergeSort<E extends Comparable> implements Sort<E> {

    /**
     * divide-and-conquer
     * Divide: Divide the n-element sequence to be sorted into two subsequences of n=2 elements each
     * Conquer: Sort the two subsequences recursively using merge sort
     * Combine: Merge the two sorted subsequences to produce the sorted answer
     *
     * O(nlog(n))
     *
     * @param elements the array to be sorted
     * @param order the order of sorting. allowed values are ASC or DESC
     */
    @Override
    public void apply(E[] elements, Order order) {
        sort(elements, 0, (elements.length - 1), order);
    }

    /**
     * MERGE-SORT(A,p,r)
     *   if p < r
     *     q = (p + r)/2
     *     MERGE-SORT(A,p,q)
     *     MERGE-SORT(A,(q+1),r)
     *     MERGE(A,p,q,r)
     * @param elements the array to be sorted
     * @param startIndex start index for the array
     * @param endIndex end index for the array
     * @param order the order of sorting. allowed values are ASC or DESC
     */
    private void sort(E[] elements, int startIndex, int endIndex, Order order) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            sort(elements, startIndex, midIndex, order);
            sort(elements, (midIndex + 1), endIndex, order);
            merge(elements, startIndex, midIndex, endIndex, order);
        }
    }

    /**
     * MERGE(A,p,q,r)
     *   n1 = q - p + 1
     *   n2 = r - q
     *   let L[1..n1] and R[1..n2] be new arrays
     *   for i = 1 to n1
     *     L[i] = A[p + i - 1]
     *   for j = 1 to n2
     *     R[j] = A[q + j]
     *   i = 1
     *   j = 1
     *   for k = p to r
     *     if L[i] <= R[j]
     *       A[k] = L[i]
     *       i = i + 1
     *     else
     *       A[k] = R[j]
     *       j = j + 1
     * @param elements the array to be sorted
     * @param startIndex start index for the left array
     * @param midIndex end index for the left array. Start index for right array
     * @param endIndex end index for the right array
     * @param order the order of sorting. allowed values are ASC or DESC
     */
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
