package Indirizzi;

import java.util.Objects;

/**
 * Le istanze di questa classe immutabile rappresentano un indirizzo.
 */

public class Indirizzo {
    /**
     * IR: locale != null && dominio != null && locale != "" && dominio != ""
     * AF:locale.ToString() + "@" + dominio.ToString()
     */

    public final Locale locale;
    public final Dominio dominio;

    /**
     * Inizializza un nuovo indirizzo con locale e dominio specificati
     * 
     * @param l parte locale dell'indirizzo
     * @param d dominio dell'indirizzo
     * @throws NullPointerException se l o d sono null
     */
    public Indirizzo(String l, String d) {
        Objects.requireNonNull(l, "Il locale non può essere null");
        Objects.requireNonNull(d, "Il dominio non può essere null");
        locale = new Locale(l);
        dominio = new Dominio(d);
    }

    @Override
    public String toString() {
        return locale.toString() + "@" + dominio.toString();
    }
}
