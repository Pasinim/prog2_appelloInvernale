import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Le istanze di questa classe astratta implementano i comportamenti comuni
 * delle programmazioni, estendendo l'interfaccia programmazione
 */
public abstract class ProgrammazioneAbs implements Programmazione {
    /**
     * AF giorni > 0 && giorni < numeroGiorni, 
     * RI
     */

    // variabile di istanza che rappresenta i giorni in cui avviene una proiezionie
    public final int[] giorni;
    public final int numeroGiorni;

    /**
     * Inizializza una nuova programmazione di un mese, assegnando una proiezione al
     * giorno
     * start
     * 
     * @param numeroGG numero di giorni presenti nella mensilta
     * 
     * @throws IllegalArgumentException se start non è compreso tra 0 e numeroGiorni
     * @throws IllegalArgumentException se numeroGiorni non è compreso tra 0 e 31
     */
    public ProgrammazioneAbs(String titolo, int numeroGG, int start) {
        if (numeroGG < 0 || numeroGG > 31)
            throw new IllegalArgumentException("Numero giorni non valido");
        if (start < 0 || start > numeroGG)
            throw new IllegalArgumentException("Giorno d'inizio non valido");
        numeroGiorni = numeroGG;
        giorni = new int[numeroGiorni];
        giorni[start] = start;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < numeroGiorni; i++) {
            if (giorni[i] != 0)
                s += giorni[i] + ", ";
        }
        return s.substring(s.length() - 2, s.length());
    }

    /**
     * @return Iteratore che itera sui giorni in cui è presente una programmazione
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = 0;
            int next = -1;

            @Override
            public boolean hasNext() {
                for (int i = current; i < numeroGiorni; i++) {
                    if (giorni[i] != 0) {
                        next = giorni[i];
                        current = i;
                        return true;
                    }
                }
                next = -1;
                return false;
            }

            @Override
            public Integer next() {
                if (next == -1)
                    throw new NoSuchElementException();
                return next;
            }
        };
    }
}
