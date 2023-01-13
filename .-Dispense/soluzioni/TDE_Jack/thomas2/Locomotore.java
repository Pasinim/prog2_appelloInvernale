package tde.thomas2;

import java.util.Iterator;

/**
 * Rotabile caratterizzato da una data potenza.
 * 
 * Classe immutabile.
 * 
 * Un Locomotore ha la seguente funzione d'astrazione:
 *  AF(c) = "Locomotore:" + super.toString() + potenza = this.potenza
 * Ed il seguente invariante di rappresentazione:
 *  rep_inv = super.repOk() && this.potenza > 0
 */
public class Locomotore extends AbstractRotabile {
    private final int potenza;

    /**
     * Inizializza un Locomotore di modello m, peso p e potenza pow.
     * 
     * @param m Modello.
     * @param p Peso.
     * @param pow Potenza.
     */
    public Locomotore(String m, int p, int pow){
        super(m, p);
        this.potenza = pow;

        if(!(repOk())){
            throw new IllegalArgumentException();
        }
    }

	@Override
	public int potenza() {
        return this.potenza;
	}

	@Override
	public Iterator<Dotazione> dotazioni() {
        throw new UnsupportedOperationException();
	}

    @Override
    public boolean repOk() {
        if(!super.repOk() || this.potenza <= 0){
            return false;
        }
        return true;
    }

    @Override 
    public String toString(){
        String ret = String.format("Locomotore: %s, potenza = %d", super.toString(), this.potenza);
        return ret;
    }
}
