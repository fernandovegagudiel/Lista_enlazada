package umg.edu.gt.listasenlazadas.applications;

import umg.edu.gt.listasenlazadas.circular.CircularLinkedList;

/**
 * Caso real: playlist que rota canciones de forma ciclica.
 */
public final class RoundRobinPlaylistApp {

    private RoundRobinPlaylistApp() {
    }

    public static void run() {
        CircularLinkedList<String> playlist = new CircularLinkedList<>();
        playlist.add("Cancion A");
        playlist.add("Cancion B");
        playlist.add("Cancion C");

        System.out.println("2) RoundRobinPlaylistApp");
        System.out.println("Playlist: " + playlist);
        System.out.println("Reproduciendo: " + playlist.next());
        System.out.println("Reproduciendo: " + playlist.next());
        System.out.println("Reproduciendo: " + playlist.next());
        System.out.println("Reproduciendo (reinicia ciclo): " + playlist.next());
        System.out.println();
    }
}
