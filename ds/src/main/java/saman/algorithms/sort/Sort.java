package saman.algorithms.sort;

public interface Sort<E extends Comparable> {

    enum Order { ASC, DESC }

    void apply(E[] elements, Order order);

    default void apply(E[] elements) {
        apply(elements, Order.ASC);
    }
}
