import java.util.Objects;

/**
 * OVERVIEW: Le istanze di questa classe concreta implementano l'interfaccia
 * Funzione, e rappresenta una funzione a due argomenti che ne restituisce il prodotto,
 */

public class Mul implements Funzione {

    private final Funzione f1, f2;

    public Mul(Funzione f1, Funzione f2) {
        this.f1 = Objects.requireNonNull(f1);
        this.f2 = Objects.requireNonNull(f2);
    }

    public int numeroArgomenti() {
        return 2;
    }

    public void argomento(Funzione funzione, int posizione) {
        return funzione.valuta();
    }
    
    public int valuta() {
        return f1.valuta() * f2.valuta();
    }
    
}
