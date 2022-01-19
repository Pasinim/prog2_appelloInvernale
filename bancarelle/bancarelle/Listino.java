package bancarelle;

import java.util.Iterator;

/**
 * Questa interfaccia presenta i metodi comuni a tutti i listini (i quali hanno politiche di prezzo differenti).
 * Nel listino, a ciascun giocattolo viene associato un prezzo unitario
 */
public interface Listino {
    /**
     * Dato una certa quantità e un certo giocattolo restituisce il prezzo totale. Se la quantità 
     * è <= 0 oppure il giocattolo non è presente nella bancarella solleva una eccezione.
     * @param qnty numero di giocattoli g presenti nell'inventario
     * @param g Giocattolo g
     * @return prezzo totale di g giocattoli
     */
    /**
     * Devo cercare nella mappa "Listino" g, poi applicare la politica unitaria.
     */
    public float prezzo_acquisto(final int qnty, final Giocattolo g) throws IllegalArgumentException;

    public int getPrezzo(Giocattolo next);

}
