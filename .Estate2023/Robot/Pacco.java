package Robot;

import java.util.Objects;

/*
 * Le istanze di questa classe rappresentano un pacco
 */
public class Pacco {

    /**
     * IR:
     * AF:
     */

    public final String articolo;
    public final int altezza;

    /**
     * Istanzia un nuovo pacco con l'articolo e l'altezza specificati
     * 
     * @param articolo articolo del pacco
     * @param altezza  altezza del pacco
     * @throws NullPointerException     se l'articolo è nullo
     * @throws IllegalArgumentException se l'altezza è negativa o se l'articolo è
     *                                  vuoto
     */
    public Pacco(String articolo, int altezza) {
        if (altezza < 0)
            throw new IllegalArgumentException("L'altezza non può essere negativa");
        if (articolo.isEmpty())
            throw new IllegalArgumentException("L'articolo non può essere una stringa vuota");
        Objects.requireNonNull(articolo, "L'articolo non può essere null");
        this.articolo = articolo;
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(articolo + "[" + altezza + "]");
        return sb.toString();
    }

}
