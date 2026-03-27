package umg.edu.gt.listasenlazadas.circular;

/**
 * Ejemplo didactico de lista circular.
 */
public final class CircularListExample {

    private CircularListExample() {
    }

    public static void run() {
        CircularLinkedList<String> turnos = new CircularLinkedList<>();
        turnos.add("Ana");
        turnos.add("Luis");
        turnos.add("Marta");

        System.out.println("--- Lista Circular ---");
        System.out.println("Turnos iniciales: " + turnos);
        System.out.println("Siguiente turno: " + turnos.next());
        System.out.println("Siguiente turno: " + turnos.next());
        System.out.println("Siguiente turno: " + turnos.next());
        System.out.println("Vuelve al inicio: " + turnos.next());
        System.out.println();
    }
}
