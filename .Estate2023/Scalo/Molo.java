
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Le istanze di questa classe rappresentano un insieme di navi
 * IR: navi != null
 * ogni elemento in navi deve essere diversa da null
 * ogni elemento in navi deve esser unico
 * 
 * AF: navi[0],navi[1],...,navi[n-1]
 */
public class Molo {
    private final List<Nave> navi;

    /** Istanzia un nuovo molo vuoto */
    public Molo() {
        navi = new LinkedList<Nave>();
    }

    /**
     * Se n non è già presente nel molo attracca n, altrimenti non fa nulla
     * 
     * @param n la nave da attraccare
     * @throws NullPointerException se n è null
     */
    public void attracca(Nave n) {
        Objects.requireNonNull(n, "La nave che attracca non può essere null");
        if (navi.contains(n))
            return;
        navi.add(n);
    }

    /**
     * Se il molo è vuoto lancia un'eccezione, altrimenti rimuove l'ultima nave
     * attraccata
     * 
     * @return la nave rimossa
     * @throws UnsupportedOperationException se il molo è vuoto
     */
    public Nave salpa() {
        if (navi.size() <= 0)
            throw new UnsupportedOperationException("Impossibile rimuovere nave da un molo vuoto");
        Nave ret = navi.get(navi.size() - 1);
        navi.remove(navi.size() - 1);
        return ret;
    }

    /**
     * Restituisce il peso della nave prossima a salpare
     * 
     * @return peso della nave prossima a salpare
     * @throws UnsupportedOperationException se il molo è vuoto
     */
    public int getProssimoPeso() {
        if (navi.size() <= 0)
            throw new UnsupportedOperationException("Impossibile rimuovere nave da un molo vuoto");
        return navi.get(navi.size() - 1).getPeso();
    }

    public int getNumeroNavi() {
        return navi.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" > ");
        for (int i = navi.size() - 1; i >= 0; i--) {
            sb.append(navi.get(i).toString());
            if (i != 0)
                sb.append(", ");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

}
