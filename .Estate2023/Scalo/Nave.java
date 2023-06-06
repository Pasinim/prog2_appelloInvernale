

import java.util.Objects;

/**
 * Le istanze di questa classe immutable rappresentano delle navi. 
 * IR: nome != null
 * peso > 0
 * 
 * AF: nome[peso]
 */
public class Nave {
    public final String nome; 
    public final int peso;
    
    public Nave(final String nome, final int peso) {
        Objects.requireNonNull(nome, "Il nome non deve essere nullo");
        if (peso <= 0) throw new IllegalArgumentException("Il peso deve essere un valore positivo");
        this.peso = peso;
        this.nome = nome;
    }

    /**
     * @return il pesno di this
     */
    public int getPeso(){
        return this.peso;
    }
    
    @Override
    public boolean equals(Object n){
        Objects.requireNonNull(n);
        if (!(n instanceof Nave)) return false;
        final Nave obj = (Nave) n;
        return obj.nome.equals(this.nome) && obj.peso == this.peso;
    }

    @Override
    public String toString(){
        return String.format("%s[%d]", this.nome, this.peso);
    }
}
