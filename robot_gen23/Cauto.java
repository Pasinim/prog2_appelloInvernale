import java.util.Objects;

// * un robot "cauto", caratterizzato da una *altezza massima* in grado di
//   spostare più di un pacco se e solo se (oltre al primo pacco che è sempre in
//   grado di spostare a prescindere dall'altezza), la somma delle altezze dei
//   pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza
//   massima consentita;

public class Cauto implements Robot {

    private final Magazzino magazzino;
    public final int altezzaMassima;

    /**
     * Inizializza un nuovo robot micro nel magazzino specificato
     * 
     * @param m il magazzino in cui il robot opera
     * @throws NullPointerException se il magazzino specificato è nullo
     */
    public Cauto(final Magazzino m, final int altezza) {
        Objects.requireNonNull(m, "Il magazzino non può essere null");
        if (altezza <= 0)
            throw new IllegalArgumentException("L'altezza deve essere maggiore di 0");
        magazzino = m;
        altezzaMassima = altezza;
    }

    /**
     * Da implementare correttamente la gestione dell'altezza massima
     */
    @Override
    public void deposita(int numeroPacchi, int start, int end) {
        int altezzaCorrente = 0;
        Scaffalatura tmp = new Scaffalatura();
        while (altezzaCorrente <= altezzaMassima) {
            for (int i = 0; i < numeroPacchi; i++) {
                Pacco p = magazzino.preleva(start);
                tmp.deposita(p);
                altezzaCorrente += p.altezza;
            }
            for (int i = 0; i < numeroPacchi; i++) {
                Pacco p = tmp.preleva();
                magazzino.deposita(p, end);
            }
        }
        throw new UnsupportedOperationException(
                "TODO: Implementare quando il numero di pacchi supera l'altezza massiama");
    }

}
