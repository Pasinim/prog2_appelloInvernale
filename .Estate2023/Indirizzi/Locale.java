package Indirizzi;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

//* OVERVIEW: Le istanze di questa classe rappresentano la parte locale di un indirizzo mail */
public class Locale {

    /**
     * AF: locale not null && locale != "" && locale rispetta la regex
     * RI: locale.toString()
     */
    final static Predicate<String> VALIDO = Pattern.compile("^[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*$").asPredicate();
    public final String locale;

    public Locale(String s) {
        Objects.requireNonNull(s, "Il locale non può essere null");
        if (s.isEmpty())
            throw new IllegalArgumentException("Il locale non può essere una stringa vuota");
        if (!VALIDO.test(s))
            throw new IllegalArgumentException("L'indirizzo locale non rispetta la regex");
        locale = s;
    }

    public boolean equals(Object o) {
        Objects.requireNonNull(o, "L'oggetto non può essere null");
        if (!(o instanceof Locale))
            return false;
        Locale l = (Locale) o;
        return locale.equals(l.locale);
    }

    public int hashCode() {
        return Objects.hash(locale);
    }

}
