import filesystem;

import java.util.List;

/**
 * Fornisce il contratto da rispettare per una Entry.
 * 
 * Una Entry é un elemento del Filesystem, caratterizzato da un nome ed una
 * dimensione validi.
 * 
 * Ogni implementazione di Entry deve fornire un metodo repOk ed un metodo
 * toString per implementare rappresentante e funzione d'astrazione
 */
public interface Entry {
    /**
     * Restituisce il nome della Entry.
     * 
     * @return Nome della Entry
     */
    public String getNome();

    /**
     * Fornisce la dimensione della Entry, sottoforma di intero rappresentante il numero di byte.
     * 
     * @return Dimensione della Entry
     */
    public int getDimensione();

    /**
     * Restituisce una Lista contenente eventuali Entry salvate all'interno della Entry this.
     * 
     * @return Lista di Entry contenute in this.
     */
    public List<Entry> getContenuto();

    @Override
    public String toString();

    @Override
    public boolean equals(Object o);

    /**
     * Controlla l'invariante di rappresentazione, nello specifico ritorna true se é rispettato, false altrimenti.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk();

}
