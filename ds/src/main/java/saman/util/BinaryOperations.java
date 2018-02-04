package saman.util;

import java.util.Comparator;

public final class BinaryOperations {

    public static <T> void swap(T[] elements, int index1, int index2) {
        T swap = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = swap;
    }

    public static <T> boolean less(T[] elements, int index1, int index2, Comparator<T> comparator) {
        return comparator.compare(elements[index1],elements[index2]) == -1;
    }

    public static <T extends Comparable> boolean less(T[] elements, int index1, int index2) {
        return elements[index1].compareTo(elements[index2]) == -1;
    }

}
