import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Le istanze di questa classe ( mutabile ) rappresentano un molo di navi cargo, da cui possono salpare o attraccare una alla volta.
 * Il primo di una sequenza di cargo che attraccano sarà l'ultimo a salpare.
 */
public class Molo {
    /**
     * RI: navi != null, navi non contiene nessun riferimento null
     * AF: Per ogni nave i presente in navi: i[0].toString + ", " + i[1].toString() + ", " + ... +  i[navi.size-1].toString()  */

    private final LinkedList<Nave> navi;
    	
    /**
     * Instanzia un nuovo molo (vuoto)
     */
    public Molo() {
        navi = new LinkedList<Nave>();
    }
    
    /**
     * Fa salpare l'ultima nave attraccata nel molo
     * @return Nave salpata
     * @throws UnsupportedOperationException se non è presente nessuna nave nel molo 
     */
    public Nave salpa(){
        if (navi.size() == 0) throw new UnsupportedOperationException("Molo vuoto, impossibile salpare");
        Nave n = navi.removeFirst();
        return n;
    }

    /**
     * Fa attraccare una nave in this (se non è già presente nel molo). 
     * @param n Nave da attraccare
     * @throws NullPointerExpection se n è null
     * @throws UnsupportedOperationException se la nave è già presente nel molo.
     */
    public void attracca(Nave n){
        Objects.requireNonNull(n, "La nave è null, impossibile attraccare");
        if (navi.contains(n)) throw new UnsupportedOperationException("impossibile far attraccare una nave già presente nel molo");
        navi.addFirst(n);
    }

    /**
     * Restituise il numero di nave presenti nel molo
     * @return numero di nave presenti nel molo
     */
    public int moloSize(){
        return navi.size();
    }

    public String toString() {
        String ret = "";
        Iterator<Nave> it = navi.iterator();
        while (it.hasNext())
            ret += it.next().toString() + ", ";
        if (ret.isEmpty()) return ret;
        return ret.substring(0, ret.length() - 2);
    }
}
