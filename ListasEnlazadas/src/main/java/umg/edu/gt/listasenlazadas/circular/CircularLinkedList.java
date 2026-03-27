package umg.edu.gt.listasenlazadas.circular;

/**
 * Implementacion de lista circular simple.
 *
 * @param <T> tipo de dato almacenado
 */
public class CircularLinkedList<T> {
    private CircularNode<T> tail;
    private CircularNode<T> current;
    private int size;

    public void add(T value) {
        CircularNode<T> newNode = new CircularNode<>(value);
        if (tail == null) {
            newNode.setNext(newNode);
            tail = newNode;
            current = newNode;
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T peekCurrent() {
        return current == null ? null : current.getValue();
    }

    public T next() {
        if (current == null) {
            return null;
        }
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

    public boolean remove(T value) {
        if (tail == null) {
            return false;
        }

        CircularNode<T> previous = tail;
        CircularNode<T> node = tail.getNext();

        for (int i = 0; i < size; i++) {
            if (isSameValue(node.getValue(), value)) {
                if (size == 1) {
                    tail = null;
                    current = null;
                } else {
                    previous.setNext(node.getNext());
                    if (node == tail) {
                        tail = previous;
                    }
                    if (node == current) {
                        current = node.getNext();
                    }
                }
                size--;
                return true;
            }
            previous = node;
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
     * RETO 2:
     * Calcula cuantos saltos se necesitan desde el nodo actual
     * para encontrar por primera vez el valor indicado.
     *
     * Reglas sugeridas:
     * - Recorrer como maximo "size" nodos para evitar ciclos infinitos.
     * - Si no existe el valor, retornar -1.
     * - No modificar la referencia "current" al finalizar.
     *
     * @param value valor objetivo
     * @return cantidad de saltos, o -1 si no existe
     */
    public int jumpsToValue(T value) {
        throw new UnsupportedOperationException(
                "TODO RETO: Implementar jumpsToValue(T value) en CircularLinkedList.");
    }

    @Override
    public String toString() {
        if (tail == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        CircularNode<T> node = tail.getNext();
        for (int i = 0; i < size; i++) {
            builder.append(node.getValue());
            if (i < size - 1) {
                builder.append(", ");
            }
            node = node.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
