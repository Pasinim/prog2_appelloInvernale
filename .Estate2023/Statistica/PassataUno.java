package Statistica;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Scanner;

/**
 * Le istanze di questa classe rappresentano le statistiche con una singola
 * passata
 */
public class PassataUno implements Statistica {

    /**
     * RI:nessuna(?)
     * AF: Media, Varianza
     */

    private double media;
    private double varianza;

    /**
     * Inizializza una nuova PassataUno da un array di osservazioni
     * 
     * @param osservazioni array di osservazioni
     */
    public PassataUno(final double[] osservazioni) {
        Objects.requireNonNull(osservazioni, "Array osservazioni nullo");
        double somma = 0;
        double sommaQuadrati = 0;
        for (double o : osservazioni) {
            somma += o;
            sommaQuadrati += o * o;
        }

        media = somma / osservazioni.length;
        varianza = ((osservazioni.length * sommaQuadrati) - (somma * somma))
                / (osservazioni.length * (osservazioni.length - 1));
    }

    @Override
    public double media() {
        return media;
    }

    @Override
    public double varianza() {
        return varianza;
    }

    @Override
    public String toString() {
        return String.format(" %.8e, %.8e", media(), varianza());
    }

}
