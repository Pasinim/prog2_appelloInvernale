package tde.treni;

/**
 * Classe immutabile Dotazione.
 * 
 * Rappresenta la Dotazione di un Vagone, caratterizzata da un nome ed una quantita'.
 * 
 * Una tipica istanza di Dotazione puo' essere rappresentata tramite la funzione d'astrazione:
 *  AF(c) = this.nome = this.quantita'
 * 
 * Ogni istanza di Dotazione rispetta inoltre il seguente invariante:
 *  this.nome != "" && this.nome != null && this.quantita > 0
 * Ogni Dotazione ha quindi un nome valido ed una quanita maggiore di 0.
 */
public class Dotazione implements Comparable<Dotazione>{
    public final String nome;
    public final int quant;

    /**
     * Inizializza una Dotazione con nome e relativa quantita'.
     * 
     * @param nome Nome Dotazione.
     * @param quantita Quantita' Dotazione.
     */
    public Dotazione(final String nome, final int quantita) throws FailureException{
        this.nome = nome;
        this.quant = quantita;

        if(!repOk()){
            throw new FailureException();
        }
    }


    @Override
    /**
     * Implementa il metodo compareTo.
     * 
     * Nello specifico date due istanze d1,d2 di Dotazione ho:
     * - d1 > d2 sse d1.quant > d2.quant
     * - d1 = d2 sse d1.quant == d2.quant
     * - d1 < d2 sse d1.quant < d2.quant
     * 
     * @param o Dotazione da comparare
     * @return Ritorna -1, 0, 1 rispettivamente se d1<d2, d1 = d2, d1>d2
     */
    public int compareTo(Dotazione o) {
        Integer i1 = (Integer) this.quant;
        Integer i2 = (Integer) o.quant;

        return i1.compareTo(i2);
    }

    @Override
    /**
     * Ritorna True se o == this.
     * 
     * Essendo Dotazione immutabile il concetto di equivalenza e' cosi' definito:
     *  Date due istanze di Dotazione d1,d2 d1 == d2 sse d1.nome == d2.nome
     * Informalmente quindi due Dotazione saranno equivalenti se il loro nome e' equivalente 
     * indipendentemente dalla classe.
     * 
     * @return True se o == this.
     */
    public boolean equals(Object o){
        if(o == this){
            return true;
        }

        if(!(o instanceof Dotazione)){
            return false;
        }

        Dotazione d = (Dotazione) o;

        return this.nome.equals(d.nome);

    }

    @Override
    /**
     * Implementa hashCode.
     * 
     * Se due Dotazioni sono equivalenti hanno lo stesso hashCode.
     * 
     * Formalmente:
     * Date due istanze d1,d2 di Dotazione, d1.hashCode() == d2.hashCode sse d1.equals(d2).
     */
    public int hashCode(){
        int result = this.nome.hashCode();

        return result;
    }

    @Override
    /**
     * Implementa la funzione d'astrazione.
     */
    public String toString(){
        String s = String.format("%s = %d", this.nome, this.quant);

        return s;
    }

    /**
     * Controlla l'invariante della classe, ritorna True se questo e' rispettato, False altrimenti.
     * 
     * @return True se l'invariante e' rispettato, False altrimenti.
     */
    public boolean repOk(){
        if(this.nome == null || this.nome == ""){
            return false;
        }
        if(this.quant <= 0){
            return false;
        }
        return true;
    }
}
