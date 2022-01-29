import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una playlist e sono mutabili. Ogni playlist è identificata da un nome e da un insieme di 
 * brani. 
 * AF:
 * RI:
 */

public class Playlist {
    /**
     * VARIABILI DI ISTANZA:
     * Il nome di una playlist può cambiare, per questo motivo e dichiarato come private. 
     * Sebbene list (in canzoni) abbia già il metodo add, è meglio costruire dei metodi che aggiungono e rimuovono le canzoni, 
     * in modo tale da controllare direttamente che la stringa delle canzoni non sia null e in modo da calcolare la durata totale
     * facendo somme e sottrazioni
     */
    private String nome;
    private final List<Album.Brano> canzoni = new ArrayList<>();
}
