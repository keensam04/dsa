package saman.algorithms.sort;

import java.util.Comparator;

public interface Sort<E> {

    enum Order { ASC, DESC }

    void apply(E[] elements, Order order, Comparator comparator);

    default void apply(E[] elements, Order order) {
        if (elements instanceof Comparable[]) {
            apply(elements, order, (object1, object2) -> ((Comparable)object1).compareTo(object2));
        } else {
            throw new IllegalArgumentException("elements need to implement java.lang.Comparable");
        }
    }

    default void apply(E[] elements) {
        apply(elements, Order.ASC);
    }
}
