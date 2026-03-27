package umg.edu.gt.listasenlazadas.retos;

import umg.edu.gt.listasenlazadas.circular.CircularLinkedList;
import umg.edu.gt.listasenlazadas.doubly.DoublyLinkedList;
import umg.edu.gt.listasenlazadas.simple.SinglyLinkedList;

/**
 * Laboratorio de retos para obligar a extender el codigo base de las estructuras.
 *
 * Cada reto depende de un metodo nuevo que debe implementarse directamente
 * en la clase de estructura correspondiente.
 */
public final class LinkedListChallenges {

    private LinkedListChallenges() {
    }

    public static void run() {
        System.out.println("=== RETOS DE IMPLEMENTACION ===");
        challenge1CountOccurrences();
        challenge2JumpsInCircularList();
        challenge3IndexFromTail();
        System.out.println();
    }

    private static void challenge1CountOccurrences() {
        SinglyLinkedList<String> eventos = new SinglyLinkedList<>();
        eventos.addLast("LOGIN");
        eventos.addLast("CLICK");
        eventos.addLast("LOGIN");
        eventos.addLast("SCROLL");
        eventos.addLast("LOGIN");

        System.out.println("Reto 1 - Analitica de eventos (lista simple)");
        System.out.println("Eventos: " + eventos);
        try {
            int totalLogins = eventos.countOccurrences("LOGIN");
            System.out.println("Resultado esperado para LOGIN: 3");
            System.out.println("Resultado obtenido: " + totalLogins);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }

    private static void challenge2JumpsInCircularList() {
        CircularLinkedList<String> turnos = new CircularLinkedList<>();
        turnos.add("Caja-1");
        turnos.add("Caja-2");
        turnos.add("Caja-3");
        turnos.add("Caja-4");

        turnos.next();
        turnos.next();

        System.out.println("Reto 2 - Planificacion de turnos (lista circular)");
        System.out.println("Turnos: " + turnos);
        System.out.println("Nodo actual de referencia: " + turnos.peekCurrent());
        try {
            int saltos = turnos.jumpsToValue("Caja-1");
            System.out.println("Resultado esperado (desde Caja-3): 2");
            System.out.println("Resultado obtenido: " + saltos);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }

    private static void challenge3IndexFromTail() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();
        historial.addLast("v1");
        historial.addLast("v2");
        historial.addLast("v3");
        historial.addLast("v4");

        System.out.println("Reto 3 - Versionado de documentos (doblemente enlazada)");
        System.out.println("Historial: " + historial.toForwardString());
        try {
            int indice = historial.indexFromTail("v2");
            System.out.println("Recorrido inverso: [v4, v3, v2, v1]");
            System.out.println("Resultado esperado para v2: 2");
            System.out.println("Resultado obtenido: " + indice);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
