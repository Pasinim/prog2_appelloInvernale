package Playfy;

import java.util.Objects;

/**
 * Le istanze di questa classe immutabile rappresentano una durata.
 */
public class Durata {
    public final int secondi;

    /**
     * Inizializza una nuova durata a partire da una stringa nel formato hh:mm:ss
     * 
     * @param s la stringa da cui inizializzare la durata
     * @throws NullPointerException     se la stringa è nulla
     * @throws IllegalArgumentException se la stringa non è nel formato hh:mm:ss
     * @throws IllegalArgumentException se la stringa contiene numeri negativi o
     *                                  maggiori di 59
     */
    public Durata(String s) {
        Objects.requireNonNull(s, "La stringa non può essere nulla");
        if (s.isEmpty())
            throw new IllegalArgumentException("La stringa non può essere vuota");
        String[] split = s.split(":");
        if (split.length != 3)
            throw new IllegalArgumentException("La stringa deve essere nel formato hh:mm:ss");
        if (Integer.parseInt(split[0]) < 0 || Integer.parseInt(split[1]) < 0 || Integer.parseInt(split[2]) < 0)
            throw new IllegalArgumentException("La stringa non può contenere numeri negativi");
        if (Integer.parseInt(split[1]) > 59 || Integer.parseInt(split[2]) > 59)
            throw new IllegalArgumentException("La stringa non può contenere numeri maggiori di 59");
        this.secondi = Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

    /**
     * Inizializza una nuova durata a partire da un numero di secondi
     * 
     * @param secondi il numero di secondi da cui inizializzare la durata
     * @throws IllegalArgumentException se il numero di secondi è negativo
     */
    public Durata(int secondi) {
        if (secondi < 0)
            throw new IllegalArgumentException("La durata non può essere negativa");
        this.secondi = secondi;
    }

    /**
     * Restituisce una nuova durata che è la somma di questa durata con un'altra
     * 
     * @param other Durata da sommare a this
     * @return la somma di this e other
     * @throws IllegalArgumentException se other è nulla
     */
    public Durata somma(Durata other) {
        Objects.requireNonNull(other, "La durata non può essere nulla");
        return new Durata(this.secondi + other.secondi);
    }

    /**
     * Restituisce una nuova durata che è la differenza di questa durata con
     * un'altra
     * 
     * @param other Durata da sottrarre a this
     * @return la differenza di this e other
     * @throws IllegalArgumentException se other è nulla
     */
    public Durata sottrai(Durata other) {
        Objects.requireNonNull(other, "La durata non può essere nulla");
        if (this.secondi >= other.secondi)
            return new Durata(this.secondi - other.secondi);
        else
            return new Durata(other.secondi - this.secondi);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.secondi / 3600, this.secondi % 3600 / 60, this.secondi % 60);
    }

    public static void main(String[] args) {
        Durata d = new Durata("01:02:03");
        System.out.println(d.toString());
        Durata x = new Durata(3723);
        System.out.println(x.toString());
        Durata y = d.somma(x);
        System.out.println(y.toString());
        Durata z = d.sottrai(x);
        System.out.println(z.toString());
    }

}
