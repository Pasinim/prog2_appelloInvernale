package tde.excel;

/**
 * Classe astratta che rappresenta un Contenuto.
 * 
 * Ogni Contenuto contiene un valore.
 */
public abstract class Contenuto {
    /**
     * Ritorna il valore del Contenuto this.
     * 
     * @return Valore, sottoforma di intero, di this.
     */
    public abstract int getValore();

    @Override
    /**
     * Da non re-implementare
     */
    public String toString(){
        String ret = String.format("%s", getValore());
        return ret;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    /**
     * Controlla l'invariante della classe.
     * 
     * @return True se l'invariante é rispettato, False altrimenti.
     */
    public abstract boolean repOk();
}
