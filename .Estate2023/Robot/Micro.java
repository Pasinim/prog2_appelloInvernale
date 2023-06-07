package Robot;

import java.util.Objects;

/**
 * Overview: Le istanze di questa classe rappresentano un robot micro che opera
 * in un magazzino logistico
 */

public class Micro implements Robot {
    /**
     * IR:
     * AF:
     */

    // variabile che rappresenta il magazzino in cui il robot opera
    private final Magazzino magazzino;

    /**
     * Inizializza un nuovo robot micro nel magazzino specificato
     * 
     * @param m il magazzino in cui il robot opera
     * @throws NullPointerException se il magazzino specificato è nullo
     */
    public Micro(final Magazzino m) {
        Objects.requireNonNull(m, "Il magazzino non può essere null");
        magazzino = m;
    }

    /**
     */
    @Override
    public void deposita(int numeroPacchi, int start, int end) {
        if (numeroPacchi < 0)
            throw new IllegalArgumentException("Il numero di pacchi non può essere negativo");
        for (int i = 0; i < numeroPacchi; i++) {
            Pacco p = magazzino.preleva(start);
            magazzino.deposita(p, end);
        }
    }

}
