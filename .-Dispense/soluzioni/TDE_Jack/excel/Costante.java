package tde.excel;

/**
 * Classe sottotipo di Contenuto il cui valore é sempre rappresentato da una costante int.
 * 
 * Classe immutabile.
 * 
 * La funzione d'astrazione di Costante puó essere definita come:
 *  AF(c) = this.valore
 * 
 * Una Costante puó contenere qualsiasi numero nel dominio degli int, di conseguenza:
 *  inv_rep = true
 */
public class Costante extends Contenuto {
    private final int valore;

    /**
     * Inizializza una costante con valore V.
     * 
     * @param v Valore di this.
     */
    public Costante(int v){
        this.valore = v;
    }

    @Override
    public int getValore() {
        return this.valore;
    }

    @Override
    public boolean equals(Object o) {
        //Dati due istanze di Contenuto (c1,c2), c1.equals(c2) sse c1.getValore == c2.getValore 

        //Se o non é Contenuto o sottotipo di esso ritorno false.
        if(!(o instanceof Contenuto)){
            return false;
        }

        if(o == this){
            return true;
        }

        Contenuto c = (Contenuto) o;
        if(this.getValore() == c.getValore()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        Integer v = (Integer) valore;
        return v.hashCode();
    }

    @Override
    public boolean repOk() {
        return true;
    }
    
}
