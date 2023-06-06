import java.util.Objects;

public class SuperRimorchiatore implements Rimorchiatore {

    public final Scalo scalo;

    public SuperRimorchiatore(Scalo s) {
        Objects.requireNonNull(s, "Lo scalo non può essere nullo");
        scalo = s;
    }

    @Override
    public void sposta(int numeroNavi, int partenza, int arrivo) {
        Molo start = scalo.getMolo(partenza);
        Molo end = scalo.getMolo(arrivo);
        if (numeroNavi > scalo.getCardinalita(start)) {
            throw new IllegalArgumentException(
                    "Il numero di navi da spostare non può essere maggiore di " + start.getNumeroNavi());
        }
        Molo tmp = new Molo();
        for (int i = 0; i < numeroNavi; i++)
            tmp.attracca(scalo.salpa(start));

        for (int i = 0; i < numeroNavi; i++)
            end.attracca(tmp.salpa());

    }

}
