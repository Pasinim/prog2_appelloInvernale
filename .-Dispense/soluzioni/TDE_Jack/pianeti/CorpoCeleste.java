package tde.pianeti;

import java.util.Objects;

/**
 * Rappresenta un CorpoCeleste.
 * 
 * Ogni istanza rispetta il seguente invariante: 
 *  Il nome é significativo, ovvero non nullo e diverso da "".
 *  Ha una posizione valida, non nulla.
 */
public abstract class CorpoCeleste {
    private String nome;
    private Punto posizione;
    //Energia meccanica
    private long energia;

    /**
     * Inizializza CorpoCeleste con nome e posizione.
     * 
     * Solleva un'eccezione se i parametri non rispettano l'invariante.
     * 
     * @param nome Nome Corpo.
     * @param posizione Posizione Corpo.
     * @param vel Velocitá Corpo.
     */
    public CorpoCeleste(String nome, Punto posizione, int k, int u){
        if(nome.equals("")){
            throw new IllegalArgumentException();
        }

        this.nome = Objects.requireNonNull(nome);
        this.posizione =  Objects.requireNonNull(posizione);
        this.energia = k * u;
    }

    /**
     * Copy constructor.
     * 
     * @param c Corpoceleste
     * @return Deep Copy di c.
     */
    public CorpoCeleste(CorpoCeleste c){
        this.nome = Objects.requireNonNull(c.nome);
        this.posizione =  Objects.requireNonNull(c.posizione);
        this.energia = c.energia;
    }

    /**
     * Ritorna nome di this.
     * 
     * @return Nome di this.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Ritorna posizione di this.
     * 
     * @return Posizione di this.
     */
    public Punto getPosizione(){
        return this.posizione;
    }

    /**
     * Ritorna energia cinetica di this.
     * 
     * @return K di this.
     */
    public long getK(){
        return this.posizione.norma();
    }

    /**
     * Ritroan energia potenziale di this.
     * 
     * @return U di this.
     */
    public long getU(){
        return 0;
    }

    /**
     * Setta una nuova vel per this.
     * 
     * @param p Vel di this
     */
    public void setPos(Punto p){
        this.posizione = p;
    }

    @Override 
    public String toString(){
        String ret = String.format("%s: %s: Energia: %d ", this.nome, this.posizione.toString(), this.energia);
        return ret;
    }

    @Override
    // Due CorpiCelesti c1,c2 saranno equivalenti sse c1.nome == c2.nome
    public boolean equals(Object o){
        if(!(o instanceof CorpoCeleste)){
            return false;
        }

        if(o == this){
            return true;
        }

        CorpoCeleste c = (CorpoCeleste) o;

        if(c.nome.equals(this.nome)){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        return this.nome.hashCode();
    }
}
