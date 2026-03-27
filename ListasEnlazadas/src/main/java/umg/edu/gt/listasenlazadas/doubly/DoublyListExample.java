package umg.edu.gt.listasenlazadas.doubly;

/**
 * Ejemplo didactico de lista doblemente enlazada.
 */
public final class DoublyListExample {

    private DoublyListExample() {
    }

    public static void run() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();
        historial.addLast("Inicio");
        historial.addLast("Menu");
        historial.addLast("Perfil");
        historial.addFirst("Login");

        System.out.println("--- Lista Doblemente Enlazada ---");
        System.out.println("Recorrido normal: " + historial.toForwardString());
        System.out.println("Recorrido inverso: " + historial.toBackwardString());
        System.out.println("Salir de perfil: " + historial.removeLast());
        System.out.println("Estado final: " + historial);
        System.out.println();
    }
}
