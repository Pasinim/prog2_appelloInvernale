import java.util.*;
/**
 * OVERVIEW: Classe astratta che rappresenta un rotabile. 
 */

public abstract class Rotabile {
    public final String modello;
    private final int peso;

    /**
     * Instanzia un nuovo rotabile
     * @param m 
     * @param p
     */
    public Rotabile(final String m, final int p){
        if (m.isEmpty()) throw new IllegalArgumentException();
        if (p < 1) throw new IllegalArgumentException();
        this.modello = Objects.requireNonNull(m);
        this.peso = p;
    }

    /**
     * @return Peso di this
     */
    public int getPeso(){
        return peso;
    }

    public String getModello(){
        return modello;
    }


}
