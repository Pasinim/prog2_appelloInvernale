package Statistica;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Scanner;

public class PassataUno implements Statistica {

    private double media;
    private double varianza;

    public PassataUno(final double[] osservazioni) {
        int somma = 0;
        int sommaQuadrati = 0;
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
