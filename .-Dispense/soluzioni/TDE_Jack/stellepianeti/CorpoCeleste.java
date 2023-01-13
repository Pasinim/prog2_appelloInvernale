package tde.stellepianeti;

/**
 * Classe astratta CorpoCeleste.
 * 
 * Un CorpoCeleste è descritto dal suo nome e dalla sua posizione, intesa come punto tridimensionale.
 * Ogni CorpoCeleste ha inoltre un valore di energia potenziale ed energia cinetica.
 * 
 */
public abstract class CorpoCeleste {
    private final String nome;
    private Punto posizione;
    private int e_potenziale;
    private int e_cinetica; 

    public CorpoCeleste(String n, Punto p, int u, int k){
        this.nome = n;
        // Essendo Punto immutabile posso direttamente assegnarlo all'istanza senza rischiare di rompere l'encapsulation 
        this.posizione = p;
        this.e_cinetica = k;
        this.e_potenziale = u;
    }

    /**
     * Simula l'interazione tra this e un'altro CorpoCeleste l'interazione sara' differente a seconda 
     * della tipologia di CorpoCeleste.
     * 
     * @param c CorpoCeleste con cui simulare l'interazione.
     */
    abstract void interagisci(CorpoCeleste c);

    /**
     * Ritorna la posizione corrente di this sottoforma di coordinate espresse tramite Punto.
     * 
     * @return Punto rappresentante la corrente posizione di this.
     */
    public Punto get_Position(){
        return this.posizione;
    }

    public void set_Position(Punto p){
        this.posizione = p;
    }

    /**
     * Setta this.energiaCinetica = k
     */
    public void  set_k(int k){
        this.e_cinetica = k;
    }

    /**
     * Setta this.energiaPotenziale = u
     */
    public void set_u(int u){
        this.e_potenziale = u;
    }

    @Override 
    /**
     * Rappresenta la funzione d'astrazione AF
     */
    public String toString(){
        String r = String.format("%s [Posizione: %s, U: %d, K: %d]", this.nome, this.posizione, this.e_potenziale, this.e_cinetica);
        return r;
    }

    @Override
    /**
     * Sovrascrive il metodo equals.
     * 
     * In generale un CorpoCeleste c1 == CorpoCeleste c2 se il loro nome e' equivalente indipendentemente dai valori di 
     * energia potenziale, cinetica o altri parametri aggiunti dalle implementazioni di CorpoCeleste.
     * 
     * @param o Oggetto con cui confrontare this.
     * @return True Se this == o.
     */
    public boolean equals(Object o){
        // Se sono esattemente lo stesso oggetto ritorno True
        if(o == this){
            return true;
        }

        // Se o non e' istanza di CorpoCeleste ritorno False
        if(! (o instanceof CorpoCeleste)){
            return false;
        }

        CorpoCeleste c = (CorpoCeleste) o;

        // Confronto i nomi dei CorpiCelsti
        if(this.nome == c.nome){
            return true;
        }

        return false;
    }

}
