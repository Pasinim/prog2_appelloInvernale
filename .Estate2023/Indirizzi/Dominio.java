package Indirizzi;

import java.util.regex.Pattern;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Le istanze di questa classe immutabile rappresentano un dominio di un
 * indirizzo
 */
public class Dominio {
    /**
     * IR: deve soddisfare il pattern VALIDO && dominio != null && dominio != ""
     * AF: dominio.toString()
     */

    final static Predicate<String> VALIDO = Pattern
            .compile("^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").asPredicate();

    public final String dominio;

    /**
     * Inizializza un nuovo dominio con la stringa specificata
     * 
     * @param dom la stringa che rappresenta il dominio
     * @throws NullPointerException     se dom è null
     *                                  throws IllegalArgumentException se dom non è
     *                                  un dominio valido
     * @throws IllegalArgumentException se dom è una stringa vuota
     */
    public Dominio(String dom) {
        Objects.requireNonNull(dom, "il dominio non può essere null");
        if (dom.isEmpty())
            throw new IllegalArgumentException("Il dominio non può essere una stringa vuota");
        if (!VALIDO.test(dom))
            throw new IllegalArgumentException("Dominio non valido");
        dominio = dom;

    }

    public boolean equals(Object o) {
        Objects.requireNonNull(o, "Il dominio non può essere null");
        if (!(o instanceof Dominio))
            return false;
        final Dominio obj = (Dominio) o;
        return obj.dominio.equals(this.dominio);
    }

    public int hashCode() {
        return Objects.hash(dominio);
    }

}
