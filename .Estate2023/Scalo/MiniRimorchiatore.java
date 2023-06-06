import java.util.Objects;

public class MiniRimorchiatore implements Rimorchiatore {

    public final Scalo scalo;

    public MiniRimorchiatore(Scalo s) {
        Objects.requireNonNull(s, "Lo scalo non può essere nullo");
        this.scalo = s;
    }

    @Override
    public void sposta(int numeroNavi, int partenza, int arrivo) {
        Objects.requireNonNull(partenza, "Il molo di partenza non può essere nullo");
        Objects.requireNonNull(arrivo, "Il molo di arrivo non può essere nullo");
        for (int i = 0; i < numeroNavi; i++) {
            Nave salpata = scalo.salpa(scalo.getMolo(partenza));
            scalo.attracca(salpata, scalo.getMolo(arrivo));
        }
    }

}
