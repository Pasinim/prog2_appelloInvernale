
/**
 * OVERVIEW: Questa interfaccia forsisce i comportamenti comuni ai vettori 
 */
public interface Vettore {
    /**
     * @return imensione del vettore
     */
    int dim();

    /**
     * @param i indice
     * @return i-esimo elemento del vettore
     */
    int val(final int i);
    
    /**
     * @param alpha scalare per cui moltiplicare this
     * @return restituisce il prodotto scalare
     * del vettore corrente per lo scalare alpha.
     */
    Vettore per(final int alpha);

    /**
     * @param v vettore a cui sommare this
     * @return somma tra v e this
     */
    Vettore piu(final Vettore v);

    /**
     * @param v vettore da confrontare con this
     * @return true se v.dim == this.dim, false altrimenti
     */
    default boolean conforme(final Vettore v){
        return this.dim() == v.dim();
    }

    /**
     * @param m matrice da confrontare con this
     * @return true se v.dim == mat.dim, false altrimenti
     */
    default boolean conforme(final Matrice m){
        return this.dim() == m.dim();
    }
}