package saman.util;

public final class BinaryOperations {

    public static <T> void swap(T[] elements, int index1, int index2) {
        T swap = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = swap;
    }
}
