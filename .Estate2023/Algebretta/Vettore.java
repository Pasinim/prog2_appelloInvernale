package Algebretta;

/**
 * Interfaccia che stabilisce il contratto di un vettore.
 */
public interface Vettore {

    /*
     * Restituisce la dimensione del vettore (numero delle sue componenti)
     * 
     * @return la dimensione del vettore
     */
    int dim();

    /**
     * Restituisce il valore della componente i-esima del vettore
     * 
     * @param i indice della componente
     * @return il valore della componente i-esima
     */
    int val(final int i);

    /**
     * Restiuisce il prodotto scalare tra this e alpha
     * 
     * @param alpha scalare
     * @return prodotto scalare tra this e alpha
     */
    Vettore per(final int alpha);

    /**
     * Restituisce la somma vettoriale tra this e v
     * 
     * @param v altro vettore
     * @return somma vettoriale
     * @throws IllegalArgumentException se alpha non è un vettore conforme
     */
    Vettore più(final Vettore v) throws IllegalArgumentException;

    /**
     * Restiuisce true se this è conforme a v
     * 
     * @param v altro vettore
     * @return true se this è conforme a v, false altrimenti
     */
    public boolean isConforme(final Vettore v);
}
