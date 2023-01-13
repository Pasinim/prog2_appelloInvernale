package tde.thomas2;

import java.util.Objects;

/**
 * Fornisce ulteriori dettagli implementativi per l'interfaccia Rotabile.
 * Fornisce inoltre una prima implementazione della funzione d'astrazione e della funzione di controllo dell'invariante.
 */
public abstract class AbstractRotabile implements Rotabile{
    private final String modello;
    private final int peso;

    /**
     * Inizializza un Rotabile di modello m e peso p.
     * 
     * @param m Modello del Rotabile
     * @param p Peso del Rotabile
     */
    public AbstractRotabile(String m, int p){
        this.modello = m;
        this.peso = p;
    }

    @Override
    public int peso(){
        return this.peso;
    }

    @Override
    public String modello(){
        return this.modello;
    }

    @Override
    public String toString(){
        String ret = String.format("modello = %s, peso = %d", this.modello, this.peso);

        return ret;
    }

    @Override
    public boolean repOk(){
        if(Objects.isNull(modello) || peso <= 0){
            return false;
        }
        return true;
    }
}
