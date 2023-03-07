/**
 * OVERVIEW: Le istanze di questa classe implementano i metodi dell'interfaccia Statistica.
 * In particolare questa classe immutabile calcola la media e la varianza in una sola passata
 */

public class PassataUno extends StatisticaAbs {

    /**
     * RI: osservazioni > 0
     * AF: osservazioni.toString() + media.toString() + varianza().toString()
     */
    public final int osservazioni;
    private double sommaOsservazioni = 0.0;
    private double sommaQuadrati = 0.0;
   
    /**
     * Inizializza una nuova PassataUno, aggiornando sommaQuadrati e sommaOsservazioni
     * @param osservazioni Numero di osservazioni lette
     * @param vals alori delle osservazioni lette
     */
    public PassataUno(int osservazioni, Double[] vals) {
        super(osservazioni, vals);
        this.osservazioni = osservazioni;
        for (int i = 0; i < osservazioni; i++) {
            sommaOsservazioni += vals[i];
            sommaQuadrati += vals[i] * vals[i];
        }
    }


    /** Restituisce la media delle osservazioni lette */
    @Override
    public double media() {
        return sommaOsservazioni/Double.valueOf(osservazioni);
    }

    /**
     * Restituisce la varianza delle osservazioni lette
     * @throws IllegalArgumentException se osservazioni == 1
     */
    @Override
    public double varianza() {
        if (osservazioni <= 1) throw new IllegalArgumentException("La varianze non può essere stimata con una sola osservazione dato che non c'è variabilità nel campione");
        return (osservazioni * sommaQuadrati 
            - sommaOsservazioni * sommaOsservazioni)
            /(Double.valueOf(osservazioni) * Double.valueOf(osservazioni - 1));
    }

    @Override
    public String toString() {
        return String.format("%d, %.8e, %.8e", osservazioni, media(), varianza());
    }
}
