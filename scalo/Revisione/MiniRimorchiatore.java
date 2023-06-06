import java.util.Objects;

import Estate2023.Molo;
import Estate2023.Rimorchiatore;
import Estate2023.Scalo;

/** OverVIew: Classe concreta che implementa i comportamenti stabiliti dall'interfaccia rimorchiatore 
 * Il rimorichiatore semplice permette di spostare una nave alla volta da un molo all'altro
*/
public class MiniRimorchiatore extends Rimorchiatore{

    public MiniRimorchiatore(Scalo s) {
        super(s);
    }

    @Override
    public int sposta(final Molo partenza, final Molo arrivo, final int quantita) {
        Objects.requireNonNull(partenza, "Molo di partenza null, impossibile spostare");
        Objects.requireNonNull(arrivo, "Molo di arrivo null, impossibile spostare");
        if (!scalo.contiene(partenza)) throw new IllegalArgumentException(String.format("Impossibile spostare, il molo di partenza non esiste nello scalo"));
        if (!scalo.contiene(arrivo)) throw new IllegalArgumentException(String.format("Impossibile spostare, il molo di partenza non esiste nello scalo"));
        int spostamenti = 0;
        for (int i = 0; i < quantita; i++) {
            Nave n = partenza.salpa();
            arrivo.attracca(n);
            spostamenti += 1;
        }
        return spostamenti;
    }
}