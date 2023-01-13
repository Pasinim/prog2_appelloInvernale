package tde.bancarelle;

import java.util.Objects;

/**
 * Classe immutabile Giocattolo.
 * 
 * Rappresenta un giocattolo, caratterizzato da un nome e relativo materiale.
 * 
 * Una tipica istanza di Giocattolo puó essere rappresentata tramite la seguente funzione d'astrazione:
 *  AF(c) = this.nome di this.materiale
 * 
 * Ogni istanza di Giocattolo rispetta inoltre il seguente invariante:
 *  this.nome significativo -> this.nome not null && this.nome != ""
 *  this.materiale significativo -> this.materiale not null && this.materiale != ""
 */
public class Giocattolo{
    private final String nome;
    private final String materiale;

    /**
     * Inizializza un Giocattolo con nome n e materiale m.
     * 
     * Solleva un'eccezione se l'invariante non é rispettato.
     * 
     * @param n Nome giocattolo
     * @param m Materiale giocattolo
     */
    public Giocattolo(String n, String m){
        if(n == "" || m == ""){
            throw new IllegalArgumentException();
        }

        this.nome = Objects.requireNonNull(n, "Nome");
        this.materiale = Objects.requireNonNull(m, "Materiale");
    }

    /**
     * Ritorna il materiale di this.
     * 
     * @return Materiale di this.
     */
    public String getMateriale(){
        return this.materiale;
    }

    /**
     * Ritorna il nome di this.
     * 
     * @return Nome di this.
     */
    public String getNome(){
        return this.nome;
    }

    @Override
    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString(){
        String ret = String.format("%s di %s", this.nome, this.materiale);
        return ret;
    }

    @Override
    /**
     * Ritorna true se o == this.
     * 
     * Dati due istanze di Giocattolo g1,g2; g1 == g2 sse g1.nome.equals(g2.nome) && g1.materiale.equals(g2.materiale)
     *
     * @return True se o == this, False altrimenti.
     */
    public boolean equals(Object o){
        if(!(o instanceof Giocattolo)){
            return false;
        }

        if(o == this){
            return true;
        }

        Giocattolo g = (Giocattolo) o;
        if(g.nome.equals(this.nome) && g.materiale.equals(this.materiale)){
            return true;
        }

        return false;
    }

    @Override 
    /**
     * Ritorna hash code di this.
     * 
     * Noto come dati due Giocattoli g1,g2; se g1.equals(g2) allora g1.hashCode == g2.hashCode
     * 
     * @return hashCode
     */
    public int hashCode(){
        int hash = this.nome.hashCode();
        
        hash += 31*this.materiale.hashCode();

        return hash;
    }
}
