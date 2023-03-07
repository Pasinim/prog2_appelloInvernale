import java.util.Objects;
/**
 * OverView: Classe astratta che implementa parzialmente il comportamento di un rimorchiatore
 */
public abstract class Rimorchiatore {
     /*
      * AF e RI?
      */
    
    // public final Scalo scalo; PVT

    public Rimorchiatore(Scalo s) {
        Objects.requireNonNull(s, "Scalo nullo, impossibile instanziare il rimorchiatore");
        scalo = s; 
    }

      /**
     * Sposta una quantità di navi cargo dello scalo s, dal modo a al molo b

     * @param partenza molo di partenza
     * @param arrivo molo di arrivo
     * @param quantita quantità di navi cargo da spostare (contemporaneamente)
     * @return numero totale di spostamenti effettuati dal rimorchiatore
     * @throws NullPointerException se partenza o arrivo contengono dei riferimenti null
     * @throws IllegalArgumentException se partenza o arrivo non sono contenuti in this
     *         IllegalArgumentException se quantita  <= 0
     * 
     * se quantita > partenza.size todo
     */
    abstract int sposta(final Molo partenza, final Molo arrivo, final int quantita) throws IllegalArgumentException, NullPointerException;
}
