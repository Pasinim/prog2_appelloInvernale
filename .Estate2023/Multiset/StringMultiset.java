package Multiset;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Interfaccia che stabioliusce il contrato per un multiset di stringhe.
 */

interface StringMultiSet extends Iterable<String> {

    /**
     * aggiunge un elemento a questo multiset, restituendo la molteplicità di tale
     * elemento
     * dopo l’inserimento;
     * 
     * @param s elemento da aggiungere
     * @return molteplicità di s dopo l'inserimento
     * @throws NullPointerException     se s è null
     * @throws IllegalArgumentException se s è una stringa vuota
     */
    int add(String s);

    /**
     * rimuove un elemento da questo multiset, restituendo la molteplicità di tale
     * elemento
     * prima della rimozione (ignorando le richieste di rimuovere elementi non
     * presenti nel multiset);
     * 
     * @param s elemento da rimuovere
     * @return molteplicità di s prima della rimozione
     * @throws NullPointerException     se s è null
     * @throws IllegalArgumentException se s è una stringa vuota
     */
    int remove(String s);

    /**
     * restituisce true se e solo se l’elemento specificato appartiene a questo
     * multiset;
     * 
     * @param s elemento da cercare
     * @return true se s appartiene a questo multiset, false altrimenti
     */
    boolean contains(String s);

    /**
     * Restituisce la molteplicità (numero di volte che un dato elemento compare) in
     * this
     * 
     * @param s elemento da cercare
     * @return molteplicità di s in this, 0 se l’elemento non appartiene al multiset
     */
    int multiplicity(String s);

    /**
     * Restituisce la cardinalita di this (somma delle molteplicita)
     * 
     * @return cardinalità di this
     */
    int size();

    /*
     * restituire il multiset ottenuto come unione di questo multiset con quello
     * indicato come
     * argomento (senza modificare questo multiset, o quello passato come
     * argomento);
     * 
     * @param o multiset da unire
     * 
     * @return unione di this e o
     * 
     * @throws NullPointerException se o è null
     */
    StringMultiSet union(StringMultiSet o) throws NullPointerException;

    /**
     * Restituisce il multiset ottenuto come intersezione di questo multiset con
     * quello indicato come argomento (senza modificarli)
     * 
     * @param o
     * @return intersezione di this e o
     * @throws NullPointerException se o è null
     * 
     */
    StringMultiSet intersection(StringMultiSet o) throws NullPointerException;

}
