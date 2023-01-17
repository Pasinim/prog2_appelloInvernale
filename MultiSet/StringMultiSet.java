import java.util.Iterator;

interface StringMultiSet extends Iterable<String> {

    /**
     * Aggiunge un multiset a this
     * @param s altro multiset
     * @return molteplicità del multiset (dopo l'unione dei due insiemi)
     */
    int add(String s);

    /**
     * rimuove il multiset s da this
     * @param multiset da rimuovere
     * @return molteplicità del multiset (prima della rimozione dei due insiemi)
     */
    int remove(String s);

    /**
     * @param s elemento da cercare in this
     * @return true se s appartiene a this, false altrimenti
     */
    boolean contains(String s);

    /**
     * @param s elemento (??? va bene )
     * @return molteplicità dell'elemento. Restituisce 0 se s non appartiene a this
     */
    int multiplicity(String s);

    /**
     * @return cardinalità di this
     */
    int size();

    /**
     * @param o multiset da aggiungere a this
     * @return multiset ottenuto dall'unione di this con o (senza modificare nessuno dei due)
     */
    StringMultiSet union(StringMultiSet o);
    
    /**
     * @param o multiset da intersecare a this
     * @return multiset ottenuto dall'intersecazione di this con o (senza modificare nessuno dei due)
     */
    StringMultiSet intersection(StringMultiSet o);
    
}