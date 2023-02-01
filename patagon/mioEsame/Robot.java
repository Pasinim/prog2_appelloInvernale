import java.util.Objects;

/**
 * Interfaccia che stabilisce il contratto di un robot
 * IR: numero >= 0
 *      partenza != null
 *      arrivo != null
 */

public abstract class Robot {
    /* Il numero di pacchi da spostare */
    public final int numero;

    /* Scaffalatura da cui spostare i pacchi */
    public final Scaffalatura partenza;

    /* Scaffalatua su cui spostare i pacchi */
    public final Scaffalatura arrivo;

    /**
     * Istanzia un nuovo robot 
     * @param numero numero di pacchi da spostare
     * @param partenza Scaffalatura di partenza
     * @param arrivo Scaffalatura di arrivo
     */
    public Robot(int numero, Scaffalatura partenza, Scaffalatura arrivo) {
        if (numero <= 0) throw new IllegalArgumentException();
        Objects.requireNonNull(partenza);
        Objects.requireNonNull(arrivo);
        this.numero = numero;
        this.partenza = partenza;
        this.arrivo = arrivo;
    }

    /**
     * Sposta un numero di pacchi pari a this.numero dalla scaffalatura di partenza a quella di arrivo
     */
    public void sposta(){
        for (int i = 0; i < numero; i++){
            Pacco p = partenza.preleva();
            arrivo.deposita(p);
        }
    }
    
}
