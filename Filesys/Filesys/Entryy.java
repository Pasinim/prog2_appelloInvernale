import java.util.*;
/**
 * OVERVIEW: Interfaccia che contiene i metodi comuni ai File e alle directory
 */
public abstract class Entryy {
    public final String nome;
    /**
     * Costruttore che permette di instanziare una Entry. Viene dichiarato come protected in modo da poter essere 
     * chiamato solamente dalle sottoclassi, infatti una istanza entry non può esistere "da sola"
     * @param s Nome della entry
     */
    protected Entryy(String s){
        if (s.isEmpty()) throw new IllegalArgumentException("Il nome di una entry non può essere vuoto");
        nome = Objects.requireNonNull(s);
    }

    public abstract int dim();
    public abstract String[] path_assoluto();
    public abstract String[] path_relativo();
    public abstract boolean isDir();
}
