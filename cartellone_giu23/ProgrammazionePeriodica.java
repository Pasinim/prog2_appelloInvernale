import java.util.Iterator;

/**
 * Le istanze di questa classe concreta implementano l'interfaccia e
 * rappresentano una programmazione che avviene
 * con un intervallo di giorni regolare dopo il primo
 */
public class ProgrammazionePeriodica implements Programmazione {

    /**
     * AF:
     * RI: ogni elemento i di giorni: giorni[i] == 1 se il giorno è stato
     * programmato, 0 altrimenti
     */

    private final int[] giorni;

    /**
     * Inizializza una nuova programmazione periodica con i giorni specificati
     * 
     * @param primo   primo giorno della programmazione
     * @param secondo intervallo tra i giorni della programmazione
     */
    public ProgrammazionePeriodica(final int primo, final int secondo) {
        if (primo <= 0 || primo > 31)
            throw new IllegalArgumentException("Il giorno deve essere compreso tra 1 e 31");
        if (secondo <= 0 || secondo > 31)
            throw new IllegalArgumentException("Il giorno deve essere compreso tra 1 e 31");
        giorni = new int[31];
        for (int i = primo; i < giorni.length; i += secondo) {
            giorni[i] = 1;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public int count() {
        int c = 0;
        for (int i = 0; i < giorni.length; i++) {
            if (giorni[i] == 1)
                c++;
        }
        return c;
    }

    // todo
    public String toString() {
        return "";
    }

}
