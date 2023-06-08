package Statistica;

/**
 * Interfaccia che definisce il contratto per le classi che implementano le
 * statistiche
 */

public interface Statistica {

    /**
     * @return media delle osservazioni
     */
    public double media();

    /*
     * @return varianza delle osservazioni
     */
    public double varianza();
}
