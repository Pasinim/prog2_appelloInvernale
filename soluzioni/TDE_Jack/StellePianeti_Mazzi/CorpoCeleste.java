import java.util.Objects;


/**
 * Le istanze di questa classe rappresentano un corpo celeste.
 * Ogni corpo celeste è identificato da un nome e una posizione (punto).
 * Tale classe rappresenta la cima della gerarchia dei corpi celesti che si suddivide in pianeta e stella fissa.
 */
public abstract class CorpoCeleste implements Comparable<CorpoCeleste>{
    /**
     * AF: {@link nome} ha posizione =  {@link posizione}
     * IR: {@link nome} non può essere null e {@link posizione} non può essere null
     * Tale invariante è assicurato dall'unico costruttore.
     */
    public final String nome;
    private Punto posizione;

    /**
     * Inizializza this affinchè rappresenti un punto.
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link posizione} sia null
     * Solleva un'eccezione di tipo {@link NullPointerException} nel caso in cui {@link nome} sia null
     */
    public CorpoCeleste(String nome,Punto posizione ){
        Objects.nonNull(nome);
        Objects.nonNull(posizione);
        this.nome = nome;
        this.posizione = posizione;
    }


    public Punto getPosizione() {
        return posizione;
    }

    public void setPosizione(Punto posizione) {
        this.posizione = posizione;
    }

    public abstract long EnergiaPotenziale();

    public abstract long EnergiaCinetica();

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CorpoCeleste)) return false;
        CorpoCeleste cc = (CorpoCeleste) obj;
        if(cc.nome.equals(nome)) return true;
        return false;
    }

    @Override
    public int hashCode() {
       return nome.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s ha posizione = %s", nome, posizione.toString());
    }
    
    public int compareTo(CorpoCeleste o){
        return o.nome.compareTo(nome);
    }
}
