import java.util.*;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una dotazione, identificata da un nome e da una quantita.
 * Le istanze di questa classe sono immutabili
 * IR: nome.toString() + " = " + quantita
 * AF: 
 *      nome != null
 *      quantita > 0
 */
public class Dotazione implements Comparable<Dotazione> {
    public final String nome;
    public final int quantita;
    /**
     * Istanzia una nuova dotazione
     * @param nome nome dotazione
     * @param quantita quantita dotazione
     * @throws NullPointerExc se nome è un riferimento null
     * @throws IllegalArgumentExc se nome è una stringa vuota
     * @throws IllegalArgumentExc se quantità è < 1
     */
    public Dotazione(final String nome, final int quantita){
        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome di una dotazione non può essere nullo");
        if (quantita < 1) throw new IllegalArgumentException("La quantità di una dotazione non può essere <= 0");
        this.nome = Objects.requireNonNull(nome);
        this.quantita = quantita;
    } 

    @Override
    public int hashCode(){
        return Objects.hash(nome, quantita); 
    }

    @Override
    public boolean equals(Object o){
        Objects.requireNonNull(o);
        if (!(o instanceof Dotazione)) return false;
        final Dotazione obj = (Dotazione) o;
        return obj.nome.equals(this.nome) && obj.quantita == this.quantita;
         
    }

    public String toString(){
        return String.format("%s =  %d\n", nome, quantita);
    }

    @Override
    public int compareTo(Dotazione o) {
        Objects.requireNonNull(o);
        return this.nome.compareTo(o.nome);
    }
}
