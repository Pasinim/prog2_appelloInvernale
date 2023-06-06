import java.util.Objects;

import Estate2023.Molo;
import Estate2023.Rimorchiatore;
import Estate2023.Scalo;

/* Overview:
 * un "super" rimorchiatore in grado di spostare un numero potenzialmente
 * illimitato di navi cargo alla volta;
 */

public class SuperRimorchiatore extends Rimorchiatore {

    public SuperRimorchiatore(Scalo s) {
        super(s);
    }

    @Override
    public int sposta(Molo partenza, Molo arrivo, final int quantita) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(partenza, "Molo di partenza null, impossibile spostare");
        Objects.requireNonNull(arrivo, "Molo di arrivo null, impossibile spostare");
        if (quantita <= 0)  throw new IllegalArgumentException(String.format("Impossibile spostare, quantità non valida: %d", quantita));
        if (!scalo.contiene(partenza)) throw new IllegalArgumentException("Impossibile spostare, il molo di partenza non esiste nello scalo");
        if (!scalo.contiene(arrivo)) throw new IllegalArgumentException("Impossibile spostare, il molo di partenza non esiste nello scalo");
        
        Molo tmp = new Molo();
        for (int i = 0; i < quantita; i++) 
            tmp.attracca(partenza.salpa());
        for (int i = 0; i < quantita; i++) 
           arrivo.attracca(tmp.salpa());
        
        return 1;
    }
}