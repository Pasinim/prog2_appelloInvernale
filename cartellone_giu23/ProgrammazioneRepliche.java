import java.util.Iterator;

/**
 * Le istanze di questa classe concreta implementano l'interfaccia rappresentano
 * una programmazione
 * costituita da un varie repliche dopo il primo giorno.
 */
public class ProgrammazioneRepliche implements Programmazione {

    /**
     * AF: giorni
     * RI: ogni elemento i di giorni: giorni[i] == 1 se il giorno è stato
     * programmato, 0 altrimenti
     */

    private final int[] giorni;

    /**
     * Inizializza una nuova programmazione con il giorno e il numero di repliche
     * 
     * @param gg       giorno iniziale della programmazione
     * @param repliche numero di repliche in seguito al primo giorno
     * @throws IllegalArgumentException se gg non è compreso tra 1 e 31
     * @throws IllegalArgumentException se repliche è minore di 1 o maggiore di 31
     */
    public ProgrammazioneRepliche(int gg, int repliche) {
        if (gg <= 0 || gg > 31)
            throw new IllegalArgumentException("Il giorno deve essere compreso tra 1 e 31");
        if (repliche < 1 || repliche > 31)
            throw new IllegalArgumentException("Il numero di repliche deve essere compreso tra 1 e 31");
        giorni = new int[gg + repliche];
        for (int i = gg; i <= repliche; i++) {
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