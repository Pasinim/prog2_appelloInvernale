/**
 * Questa interfaccia definisce i comportamenti comuni di una Funzione
 * 
 */

public interface Funzione {
    /** 
     * @return numero di argomenti della funzione 
     */
    int numeroArgomenti();

    /**
     * Definisce quale altra funzione corrisponde all'argomento in posizione data
     * @param funzione
     * @param posizione 
     */
    void argomento(Funzione funzione, int posizione);

    /**
     * @return valore della Funzione
     */
    int valuta();

    /**
     * Metodo statico che permette di considerare un numero intero come una 
     * funzione con 0 argmenti.
     * @param valore valore del numero intero
     * @return valore del numero intero 
     */
    static Funzione costante(final int valore) {
        return new Funzione() {
            public int numeroArgomenti() {
                return 0;
            }

            public void argomento(Funzione funzione, int posizione) {
                throw new UnsupportedOperationException();
            }

            public int valuta() {
                return valore;
            }
        };
    }
}