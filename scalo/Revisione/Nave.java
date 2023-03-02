
import java.util.Objects;

/**
 * OVERVIEW: Le istanze di questa classe IMMUTABILE rappresentano una nave cargo, che possiede un nome ed un peso
 */
public class Nave {
    /**
     * RI:  peso > 0
     *      nome != null e nome non vuoto
     * AF: "this.nome[this.peso]"
     */

    public final String nome;
    public final int peso;
    
    /**
     * Istanzia una nuova nave
     * @param nome nome della nave
     * @param peso peso della nave
     * @throws NullPointerException se nome è null
     * @throws IllegalArgumentExpectiomn se nome è una stringa vuota oppure se il peso è <= 0
     * 
     */
    public Nave(String nome, int peso) {
        Objects.requireNonNull(nome, "Impossibile creare una nave cargo con nome null");
        if (nome.isEmpty()) throw new IllegalArgumentException("Impossibile creare una nave cargo con nome vuoto");
        if (peso <= 0) throw new IllegalArgumentException("Impossibile creare una nave cargo con un peso <= 0");
        this.nome = nome;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        Objects.requireNonNull(obj);
        if (!(obj instanceof Nave)) return false;
        Nave o = (Nave)obj;
        return (o.nome.equals(this.nome) && o.peso == this.peso);
    }

    @Override
    public int hashCode() {
      //  return nome.hashCode() + peso;  //Objects.hashCode
//        Objects.hash(nome, peso);

    public String toString(){
        return String.format("%s[%d]", nome, peso);
    }
}