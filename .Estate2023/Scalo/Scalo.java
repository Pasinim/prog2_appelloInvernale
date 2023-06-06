
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Le istanze di questa classe rappresentano uno scalo navale, composto da un
 * numero finito e non vuoto di moli
 * RI: molo != null
 * cardinalita = moli.size()
 * cardinalita >= 0
 * ogni molo nello scalo deve essere unico
 * AF: TODO
 */

public class Scalo {

    private final List<Molo> moli;

    /**
     * Come faccio a definire la lista di moli? Se faccio un metodo aggiungiMolo la
     * classe non sarebbe immutabile.
     * Se creo la lista nel costruttore devo avere già una lista nel testRunner e
     * non mi pare sia una buona pratica
     * Come faccio?
     */

    /**
     * Istanzia un nuovo scalo immutabile contentente i moli in m
     * 
     * @param m la lista di moli
     * @throws NullPointerException se m è null
     */
    public Scalo(List<Molo> m) {
        Objects.requireNonNull(m, "La lista di moli non può essere null");
        moli = List.copyOf(m);
    }

    public Molo getMolo(int i) {
        return moli.get(i);
    }

    public int getCardinalita(Molo m) {
        if (!(moli.contains(m)))
            throw new IllegalArgumentException("Il molo non è presente nello scalo");
        return m.getNumeroNavi();
    }

    /**
     * Attracca la nave n al molo m
     * 
     * @param n la nave da attraccare
     * @param m il molo su cui attraccare la nave
     * @throws NullPointerException se n o m sono null
     */
    public void attracca(Nave n, Molo m) {
        Objects.requireNonNull(n, "La nave che attracca non può essere null");
        Objects.requireNonNull(m, "Il molo non può essere null");
        m.attracca(n);
    }

    /**
     * Salpa la nave dal molo m
     * 
     * @param m il molo da cui salpare
     * @return la nave salpata
     * @throws NullPointerException     se m è null
     * @throws IllegalArgumentException se m non è presente nello scalo o se il molo
     *                                  è vuoto
     */
    public Nave salpa(Molo m) {
        Objects.requireNonNull(m, "Il molo non può essere null");
        if (!(moli.contains(m)))
            throw new IllegalArgumentException("Il molo non è presente nello scalo");
        if (moli.isEmpty())
            throw new IllegalArgumentException("Molo vuoto");
        return m.salpa();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moli.size(); i++) {
            sb.append(i + ": ");
            sb.append(moli.get(i).toString());
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}