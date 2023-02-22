import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * OVERVIEW
 * Le istanze di questa classe immutabile rappresentano la parte locale di un indirizzo.
 */
public class Locale {

    /**
     * IR:   locale deve soddisfare l'espressione regolare: `^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$`
     *         locale != null 
     * AF: locale.toString()
     */

     public final String locale;
     private static String er = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$";
     final static Predicate<String> VALIDO = Pattern.compile(er).asPredicate();


     /**
      * Istanzia una nuova parte locale
      * @param locale la parte locale
      * @throws IllegalArgumentException se locale è nulla 
      *         IllegalArgumentException se locale non soddisfa l'espressione regolare `^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$`
      */
     public Locale(String locale) {
        Objects.requireNonNull(locale, "La parte locale non può essere nulla");
        if (locale.isEmpty()) throw new IllegalArgumentException("La parte locale non può essere una stringa vuota");
        if (!VALIDO.test(locale)) throw new IllegalArgumentException("La parte locale non è in un formato valido");
         this.locale = locale;
     }

     public String toString() {
        return locale.toString();
     }        
}