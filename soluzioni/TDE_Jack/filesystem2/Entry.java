package tde.filesystem2;

import java.util.Iterator;

/**
 * Definisce il contratto di una Entry, ovvero un elemento di un Filesystem.
 * 
 * Ogni Entry é caratterizzata da un nome ed eventualmente una dimensione e/o un
 * contenuto.
 * 
 * Ogni implementazione dell'interfaccia Entry deve anche implementare funzione
 * d'astrazione e funzione per il controllo dell'invariante.
 */
public interface Entry {
    
    /**
     * Ritorna il nome della Entry.
     * 
     * @return Nome della Entry.
     */
    public String nome();

    /**
     * Ritorna la dimensione di this.
     * 
     * Ritorna 0 se la Entry non ha una dimensione e/o il valore di tale dimensione é trascurabile
     * 
     * @return Dimensione di this.
     */
    public int dimensione();

    /**
     * Ritorna un Generatore che permette di iterare sulle Entry contenute in this.
     * 
     * Se la Entry non contiene ulteriori Entry viene ritornato null.
     *  
     * @return Iterator sul contenuto, se presente, di this, altrimenti null.
     */
    public Iterator<Entry> contenuto();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();

    @Override
    public String toString();

    /**
     * Controlla l'invariante di rappresentazione.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public boolean repOk();

}
