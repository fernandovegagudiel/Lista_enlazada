package umg.edu.gt.listasenlazadas.doubly;

/**
 * Implementacion de lista doblemente enlazada.
 *
 * @param <T> tipo de dato
 */
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public void addFirst(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T value = tail.getValue();
        tail = tail.getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        DoublyNode<T> node = head;
        while (node != null) {
            if (isSameValue(node.getValue(), value)) {
                if (node == head) {
                    removeFirst();
                } else if (node == tail) {
                    removeLast();
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                    size--;
                }
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * RETO 3:
     * Busca un valor iniciando desde el final (tail) y devuelve su indice
     * relativo al recorrido inverso.
     *
     * Ejemplo:
     * Lista: [A, B, C, D]
     * Recorrido inverso: [D, C, B, A]
     * indexFromTail(D) = 0, indexFromTail(B) = 2
     *
     * Reglas sugeridas:
     * - Resolver usando enlaces previos (previous).
     * - No convertir a string ni usar estructuras auxiliares.
     * - Si no existe, retornar -1.
     *
     * @param value valor a buscar
     * @return indice desde tail o -1 si no existe
     */
    public int indexFromTail(T value) {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar indexFromTail(T value) en DoublyLinkedList.");
    }

    public String toForwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> node = head;
        while (node != null) {
            builder.append(node.getValue());
            if (node.getNext() != null) {
                builder.append(", ");
            }
            node = node.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public String toBackwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> node = tail;
        while (node != null) {
            builder.append(node.getValue());
            if (node.getPrevious() != null) {
                builder.append(", ");
            }
            node = node.getPrevious();
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        return toForwardString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
