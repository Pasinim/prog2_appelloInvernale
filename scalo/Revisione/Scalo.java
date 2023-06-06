import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

import Estate2023.Molo;

/**
 * OVERVIEW: Le istanze di questa classe mutabile rappresentano uno scalo, che possiede un elenco di moli.
 */
public class Scalo {

    /**
     * IR: il riferimento a moli non deve essere null
     *       moli non deve contenere nessun riferimento a null
     * AF: Per ogni molo i >= 0: 
     *  0: < moli.get(0).toString()
     *  1: < moli.get(1).toString()
     * ...
     *  i - 1: < moli.get(i - 1).toString()
     */
    private final ArrayList<Molo> moli;

    /** Inizializza un nuovo scalo vuoto */
    public Scalo () {
        moli = new ArrayList<Molo>();
    }

    /**
     * Restituisce il molo m di indice i
     * @param idx  indice del molo da restituire
     * @return moli[idx]
     * @throws NoSuchElementException se m non è presnete in this
     */
    public Molo getMolo(int idx) {
        if (moli.size() <= (idx)) throw new NoSuchElementException("Molo " + idx + " non trovato");
        return moli.get(idx);
    }
    
    /**
     * Aggiunge un molo allo scalo. Se il molo è già presente non fa nulla
     * @param m Molo da aggiungere
     * @throws NullPointerException se m è un riferimento null
     */
    public void aggiungi(final Molo m) {
        Objects.requireNonNull(m, "Impossibile aggiungere un molo null");
        if (moli.contains(m)) return;
        // else moli.add(m);
        // m.equals(m)

    }

    /* 
     * Restituisce true se il molo è presente in this, false altrimenti
     * @param m Molo
     * @return true se m è presente in this.moli, false altrimenti
     * @throws NullPointerException se m è un riferimento null
     */
    public boolean contiene(Molo m) {
        Objects.requireNonNull(m, "Molo null, impossibile invocare il metodo");
        return moli.contains(m);  
    }

    public String toString () {
        String ret = "";
        Object[] arr = moli.toArray();
        for (int i = 0; i < arr.length; i++)
            ret += String.format("%d: < %s # \n", i, arr[i].toString());
        return ret;
    }


}
