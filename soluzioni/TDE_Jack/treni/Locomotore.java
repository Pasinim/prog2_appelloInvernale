package tde.treni;

/**
 * Classe immutabile Locomotore.
 * 
 * Rappresenta un particolare tipo di Locomotore caratterizzato da una potenza.
 * 
 * Ogni Locomore ha il seguente invariante:
 *  this.potenza > 0
 */
public class Locomotore extends Rotabile {
    private final int potenza;

    /**
     * Inizializza un Locomotore di modello m, peso p e potenza pow.
     * 
     * @param m Modello.
     * @param peso Peso.
     * @param pow Potenza.
     * @throws FailureException Se uno dei parametri non rispetta l'invariante.
     */
    public Locomotore(String m, int peso, int pow) throws FailureException{
        super(m, peso);
        this.potenza = pow;

        if(!this.repOk()){
            throw new FailureException();
        }
    }

    /**
     * Inizializza un locomotore data una String di formato
     * L Modello Peso Potenza
     * 
     * Il costruttore si aspetta in input Stringhe di questo tipo, Stringhe con formato diverso
     * potrebbero portare ad inizializzazioni incosistenti.
     * 
     * @param s Stringa del Locmotore
     */
    public Locomotore(String s) throws FailureException{
        super(s);

        String[] token = s.split(" ");
        try {
            this.potenza = Integer.parseInt(token[3]);
        } catch (Exception e) {
            throw new FailureException();
        }

        if(!this.repOk()){
            throw new FailureException();
        }
    }

    public int getPotenza() {
        return potenza;
    }

    /**
     * Controlla l'invariante di Locomotore
     */
    @Override
    public boolean repOk() {
        if(!super.repOk()){
            return false;
        }

        if(this.potenza <= 0){
            return false;
        }

        return true;
    }

    @Override
    /**
     * Implementa la funzione d'astrazione.
     */
    public String toString(){
        String s = String.format("Locomotore: modello = %s, peso = %d, potenza = %d", this.getModello(), this.getPeso(), this.potenza);
        return s;
    }

}
