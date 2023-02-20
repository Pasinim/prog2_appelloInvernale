import java.util.Objects;

/**
 * un rimorchiatore "prudente", caratterizzato da un *carico massimo* in grado di
spostare più di una nave cargo se e solo se (oltre alla prima nave cargo che è
sempre in grado di spostare a prescindere dal carico massimo), la somma delle
navi spostate in ciascun viaggio non eccede il carico massimo;
 */

public class CautoRimorchiatore extends Rimorchiatore {

    public final int caricoMassimo ;


    /**
     * Istanzia un nuovo rimorchiatore avente uno scalo e un carico massimo
     * @param s Scalo su cui lavora il rimorchiatore
     * @param caricoMassimo massimo peso che il rimorchiatore può spostare
     * @throws IllegalArgumentException se il carico massimo è minore o uguale a zero
     */    
    public CautoRimorchiatore(Scalo s, int caricoMassimo) {
        super(s);
        if (caricoMassimo <= 0) throw new IllegalArgumentException("Impossibile creare un rimorchiatore con carico massimo minore o uguale a zero");
        this.caricoMassimo = caricoMassimo;
    }

    @Override
    public int sposta(Molo partenza, Molo arrivo, int quantita) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(partenza, "Molo di partenza null, impossibile spostare");
        Objects.requireNonNull(arrivo, "Molo di arrivo null, impossibile spostare");
        if (quantita <= 0)  throw new IllegalArgumentException(String.format("Impossibile spostare, quantita non valida: %d", quantita));
        if (!scalo.contiene(partenza)) throw new IllegalArgumentException("Impossibile spostare, il molo di partenza non esiste nello scalo");
        if (!scalo.contiene(arrivo)) throw new IllegalArgumentException("Impossibile spostare, il molo di partenza non esiste nello scalo");
        Molo tmp = new Molo();
        int pesoCorrente = 0, spostamenti = 0;
        while (pesoCorrente <= caricoMassimo){
            for (int i = 0; i < quantita; i++) {
                Nave currNave = partenza.salpa();
                if ((pesoCorrente + currNave.peso) > caricoMassimo) { 
                    spostamenti += 1;
                    pesoCorrente = 0;
                    continue;
                }
                tmp.attracca(partenza.salpa());
            }
        }

        for (int i = 0; i < quantita; i++) 
            arrivo.attracca(tmp.salpa());

        return spostamenti;

    }
    
}
