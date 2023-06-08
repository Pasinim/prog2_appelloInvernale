import java.util.Arrays;

/**
 * OVERVIEW: Le istanze di questa classe implementano i metodi della classe astratta StatisticaAbs.
 * In particolare questa classe immutabile calcola la varianza in due "passate" per una maggiore precisione
 */

public class PassataDue extends StatisticaAbs {
    /**
     * RI: osservazioni > 0
     *      vals != null
     *      ogni elemento in vals non è null
     *      vals.length == osservazioni
     * AF: osservazioni.toString() + media.toString() + varianza().toString()
     */
    

    public final int osservazioni;
    /* Variabile di instanza che rappresenta l'array delle osservazioni lette. È dichiarato
     * privato in modo tale da non esporre la rappresentazione
     */
    private final Double[] vals;  
    public final double media;    

    /**
     * Inizializza una nuova PassataDue, inizializzando direttamente la media dei valori passati
     * @param osservazioni numero di osservazioni lette
     * @param vals valori delle osservazioni lette
     */
    public PassataDue(int osservazioni, Double[] vals) {
        super(osservazioni, vals);
        this.osservazioni = osservazioni;
        this.vals = Arrays.copyOf(vals, osservazioni);
        media = this.media();
    }

    @Override
    /** Restituisce la media delle osservazioni */
    public double media() {
        double sum = 0.0;
        for (int i = 0; i < osservazioni; i++) 
            sum += vals[i];
        return sum/Double.valueOf(osservazioni);   
    }

    /**
     * Restituisce la varianza delle osservazioni lette
     * @throws IllegalArgumentException se osservazioni <= 1
     */
    @Override
    public double varianza() {
        if (osservazioni <= 1) throw new IllegalArgumentException("La varianze non può essere stimata con una sola osservazione dato che non c'è variabilità nel campione");
        double sum = 0.0;
        for (int i = 0; i < osservazioni; i++) 
            sum += Math.pow(vals[i] - media, 2);
      return sum/ Double.valueOf(osservazioni - 1);
    }

    @Override
    public String toString() {
        return String.format("%d, %.8e, %.8e", osservazioni, media(), varianza());
    }
}
