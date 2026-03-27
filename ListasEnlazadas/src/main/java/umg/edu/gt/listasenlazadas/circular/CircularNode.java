package umg.edu.gt.listasenlazadas.circular;

/**
 * Nodo para lista circular.
 *
 * @param <T> tipo de dato
 */
final class CircularNode<T> {
    private final T value;
    private CircularNode<T> next;

    CircularNode(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    CircularNode<T> getNext() {
        return next;
    }

    void setNext(CircularNode<T> next) {
        this.next = next;
    }
}
