import java.util.Iterator;

/**
 * Le istanze di questa classe concreta implementano l'interfaccia rappresentano
 * una programmazione
 * costituita da un singolo giorno.
 */

public class ProgrammazioneSingola implements Programmazione {

    /**
     * AF: giorno
     * RI: giorno compreso tra 1 e 31
     */
    private final int giorno;

    /**
     * Inizializza una nuova programmazione singola con il giorno specificato
     * 
     * @param gg giorno della programmazione
     * @throws IllegalArgumentException se gg non è compreso tra 1 e 31
     */
    public ProgrammazioneSingola(final int gg) {
        if (gg <= 0 || gg > 31)
            throw new IllegalArgumentException("Il giorno deve essere compreso tra 1 e 31");
        giorno = gg;
    }

    public String toString() {
        return "" + giorno;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return giorno;
            }
        };
    }

    @Override
    public int count() {
        return 1;
    }

}
