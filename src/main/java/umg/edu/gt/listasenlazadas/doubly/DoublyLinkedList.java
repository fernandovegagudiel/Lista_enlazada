package umg.edu.gt.listasenlazadas.doubly;

/**
 * Implementacion basica de una lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
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

    public boolean contains(T value) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
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
     * RETO 1:
     * Cuenta cuantas veces aparece un valor en la lista.
     *
     * @param value valor a buscar
     * @return cantidad de ocurrencias
     */
    public int countOccurrences(T value) {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar countOccurrences(T value) en DoublyLinkedList.");
    }

    /**
     * RETO 2:
     * Limpia la lista nodo por nodo y retorna la cantidad removida.
     *
     * @return nodos eliminados
     */
    public int clean() {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar clean() en DoublyLinkedList.");
    }

    /**
     * RETO 3:
     * Invierte la lista in-place, actualizando enlaces next/previous.
     */
    public void reverseInPlace() {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar reverseInPlace() en DoublyLinkedList.");
    }

    /**
     * RETO 4:
     * Elimina nodos duplicados conservando la primera ocurrencia.
     *
     * @return cantidad de nodos eliminados
     */
    public int removeDuplicates() {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar removeDuplicates() en DoublyLinkedList.");
    }

    public String toForwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = head;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public String toBackwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = tail;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getPrevious() != null) {
                builder.append(", ");
            }
            current = current.getPrevious();
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
