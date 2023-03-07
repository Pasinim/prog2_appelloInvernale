import java.util.Arrays;

import java.util.Objects;

/**
 * OVERVIEW: Classe astratta che implementa parzialmente le funzionalità statistiche
 * 
 */

public abstract class StatisticaAbs {

    /**
     * Istanzia una nuova statistica
     * @param osservazioni numero di osservazioni effettuate
     * @param vals array di valori letti
     * @throws IllegalArgumentException se osservazioni <= 0
     * @throws NullPointerException se vals == null
     * @throws IllegalArgumentException se osservazioni != vals.length
     */
    public StatisticaAbs(final int osservazioni, final Double[] vals)  {
        Objects.requireNonNull(vals, "Array dei valori non valido");
        if (Arrays.asList(vals).contains(null)) throw new NullPointerException("I valori delle osservazioni non possono essere null");
        if (osservazioni <= 0) throw new IllegalArgumentException("Il numero di osservazioni deve essere > 0");
        if (osservazioni!= vals.length) throw new IllegalArgumentException("Il numero di osservazioni e le osservazoni lette devono essere uguali");
    }

    /** Restituisce la media delle osservazioni */
    public abstract double media();

    /** Restituisce la varianza delle osservazioni
     * @throws IllegalArgumentException se il numero delle osservazioni non è valido
     */
    public abstract double varianza() throws IllegalArgumentException;



}
