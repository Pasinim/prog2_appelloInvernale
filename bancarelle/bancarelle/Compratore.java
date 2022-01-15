package bancarelle;
import java.util.*;
/**
 * Questa classe astratta serve per definire un comportamento simile a tutti i 
 * tipi di compratori. Qui definisco solamente il costruttore, che rimane lo stesso 
 * in tutti i sottotipi, mentre lascio il metodo vuoto
 */
public abstract class Compratore {
    public final Set<Bancarella> bancarelle;
    /**
     * Inizializza un nuovo compratore, che compra da tutte le bancarelle specificate in bancarelle
     * @param bancarelle
     */
    public Compratore(Set<Bancarella> bancarelle){
        Objects.requireNonNull(bancarelle);
        this.bancarelle = bancarelle;
    }

    /**
     * Esegue l'acquisto del giocattolo g 
     * @param qnty
     * @param giocattolo
     * @return
     */
    abstract Acquisto compra (final int qnty, final Giocattolo giocattolo);

}
