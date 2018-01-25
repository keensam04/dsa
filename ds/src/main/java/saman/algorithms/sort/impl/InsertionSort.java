package saman.algorithms.sort.impl;

import saman.algorithms.sort.Sort;

import java.util.Comparator;

public class InsertionSort<E> implements Sort<E> {

    /**
     * Efficient for sorting a small number of elements.
     * Insertion sort works the way many people sort a hand of playing cards.
     * We start with an empty left hand and the cards face down on the table.
     * We then remove one card at a time from the table and insert it into the correct position in the left hand.
     * To find the correct position for a card, we compare it with each of the cards already in the hand, from right to left.
     * At all times, the cards held in the left hand are sorted, and these cards were originally the top cards of the pile on the table.
     *
     * @pseudoCode
     * for j = 2 to A.length
     *   key = A[j]
     *   // Insert A[j] into the sorted sequence A[1..(j-1)].
     *   i = j - 1
     *   while i>0 and A[i] > key
     *     A[i+1] = A[i]
     *     i = i - 1
     *   A[i+1] = key
     *
     * worst-case: when the elements are sorted in reverse order - O(n^2)
     * best-case: when the elements are sorted in correct order - O(n)
     *
     * @param elements the array to be sorted
     * @param order the order of sorting. allowed values are ASC or DESC
     */
    @Override
    public void apply(E[] elements, Order order, Comparator comparator) {
        for (int index = 1; index < elements.length; index++) {
            E key = elements[index];
            int subIndex = index - 1;
            while (subIndex >= 0 && (order.equals(Order.ASC) ?
                    comparator.compare(elements[subIndex], key) > 0 : comparator.compare(elements[subIndex], key) < 0)) {
                elements[subIndex+1] = elements[subIndex];
                subIndex = subIndex - 1;
            }
            elements[subIndex+1] = key;
        }
    }
}
