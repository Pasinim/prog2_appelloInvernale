import java.util.Objects;
/**
 * OVERVIEW: Le istanze di questa classe immutabile rappresentano un indirizzo mail, costituito da
 * una parte locale e da una parte dominio. Due indirizzi sono ugualu sse sono uguali entrambe le parti
 */
public class Indirizzo {

    /**
     * RI: locale, dominio != null

     *    
     *      dominio deve soddisfare l'espressione regolare: `^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$`
     * AF: locale.toString() + '@' + dominio.toString()
     */
    
     public final Locale l;
     public final Dominio d;

     /**
      * Istanzia un nuovo indirizzo
      * @param locale parte locale dell'indirizzo
      * @param dominio dominio dell'indirizzo
      * @throws NullPointerException se locale e dominio sono null
      */
     public Indirizzo(Locale locale, Dominio dominio) {
        Objects.requireNonNull(locale, "La parte locale dell'indirizzo non può essere null");
        Objects.requireNonNull(dominio, "Il dominio dominio dell'indirizzo non può essere null");
        this.l = locale;
        this.d = dominio;
    }

    @Override
    public int hashCode() {
        return l.hashCode() + d.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Indirizzo)) return false;
       Indirizzo other = (Indirizzo) obj;
       return l.equals(other.l) && d.equals(other.d);
    }

    public String toString() {
        return l.toString() + '@' + d.toString();
    }

}
