import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * OVERVIEW
 * Le istanze di questa classe immutabile rappresentano il dominio di un indirizzo.
 */
public class Dominio {

    /**
     * IR:   dominio deve soddisfare l'espressione regolare: `^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$`
     *         dominio != null 
     * AF: dominio.toString()
     */

     public final String dominio;
     private static String er = "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
     final static Predicate<String> VALIDO = Pattern.compile(er).asPredicate();


     /**
      * Istanzia una nuova parte dominio
      * @param dominio la parte dominio
      * @throws IllegalArgumentException se dominio è nulla 
      *         IllegalArgumentException se dominio non soddisfa l'espressione regolare `^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$`
      */
     public Dominio(String dominio) {
        Objects.requireNonNull(dominio, "La parte dominio non può essere nulla");
        if (dominio.isEmpty()) throw new IllegalArgumentException("La parte dominio non può essere una stringa vuota");
        if (!VALIDO.test(dominio)) throw new IllegalArgumentException("La parte dominio non è in un formato valido");
         this.dominio = dominio;
     }

     public String toString() {
        return dominio.toString();
     }        
}