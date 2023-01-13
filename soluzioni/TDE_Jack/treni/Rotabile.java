package tde.treni;

/**
 * Classe astratta Rotabile.
 * 
 * Rappresenta un Rotabile, parte di un convoglio caratterizzata da un modello ed un peso.
 * 
 * Un Rotabile deve avere un nome valido ed un peso maggiore di zero.
 * Formalmente:
 *  this.modello != null && this.modello != "" && this.peso > 0
 */
public abstract class Rotabile{
    private final String modello;
    private final int peso;

    /**
     * Inizializza Rotabile di modello m con peso p.
     * 
     * @param m Modello del Rotabile.
     * @param p Peso del Rotabile
     * @throws FailureException Se l'invariante non viene rispettato dai parametri in input.
     */
    public Rotabile(String m, int p) throws FailureException{
        this.modello = m;
        this.peso = p;

        if(!repOk()){
            throw new FailureException();
        }
    }

    /**
     * Inizializza un locomotore data una String di formato
     * R Modello Peso
     * 
     * Il costruttore si aspetta in input Stringhe di questo tipo, Stringhe con formato diverso
     * potrebbero portare ad inizializzazioni incosistenti.
     * 
     * @param s Stringa del Locmotore
     */
    public Rotabile(String s) throws FailureException{
        String[] token = s.split(" ");

        this.modello = token[1];
        try {
            this.peso = Integer.parseInt(token[2]);            
        } catch (NumberFormatException e) {
            throw new FailureException("Peso in formato errato");
        }
    }

    /**
     * Metodo getter peso.
     * 
     * @return Peso di this.
     */
    public int getPeso(){
        return this.peso;
    }

    /**
     * Metodo getter modello.
     * 
     * @return Modello di this.
     */
    public String getModello(){
        return this.modello;
    }

    /**
     * Controlla l'invariante della classe, definito nella specifica.
     * 
     * @return True se l'invariante e' rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(this.modello == "" || this.modello == null ){
            return false;
        }

        if(this.peso <= 0){
            return false;
        }
        
        return true;
    }

    @Override
    /**
     * Ritorna true se this.equals(o)
     * 
     * Date due istanze di Rotabile r1,r2 r1 e' equivalente ad r2 sse r1.modello equals r2.modello.
     * 
     * @return True se this e' equivalente a o, False altrimenti
     */
    public boolean equals(Object o){
        if(!(o instanceof Rotabile)){
            return false;
        }

        if(o == this){
            return true;
        }

        Rotabile r = (Rotabile) o;

        if(this.modello.equals(r.modello)){
            return true;
        }

        return false;
    }

    @Override
    /**
     * Implementa hashCode.
     * 
     * @return hashCode di this.
     */
    public int hashCode(){
        return this.modello.hashCode();
    }

}
