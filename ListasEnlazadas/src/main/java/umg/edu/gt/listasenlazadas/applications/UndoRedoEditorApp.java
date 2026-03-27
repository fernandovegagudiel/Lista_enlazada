package umg.edu.gt.listasenlazadas.applications;

import umg.edu.gt.listasenlazadas.doubly.DoublyLinkedList;

/**
 * Caso real: historial de cambios para operaciones de undo/redo.
 */
public final class UndoRedoEditorApp {

    private UndoRedoEditorApp() {
    }

    public static void run() {
        DoublyLinkedList<String> historialCambios = new DoublyLinkedList<>();
        historialCambios.addLast("Escribir titulo");
        historialCambios.addLast("Agregar introduccion");
        historialCambios.addLast("Corregir ortografia");

        System.out.println("3) UndoRedoEditorApp");
        System.out.println("Historial actual: " + historialCambios.toForwardString());

        String deshacer = historialCambios.removeLast();
        System.out.println("Undo aplicado a: " + deshacer);
        System.out.println("Historial despues de undo: " + historialCambios.toForwardString());

        historialCambios.addLast(deshacer);
        System.out.println("Redo aplicado a: " + deshacer);
        System.out.println("Historial despues de redo: " + historialCambios.toForwardString());
        System.out.println();
    }
}
