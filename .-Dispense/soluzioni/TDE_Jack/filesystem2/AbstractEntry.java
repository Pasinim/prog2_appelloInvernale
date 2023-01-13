package tde.filesystem2;

import java.util.Iterator;
import java.util.Objects;

/**
 * Fornisce ulteriori dettagli implementativi per l'interfaccia Entry.
 * 
 * Fornisce una prima implementazione della funzione d'astrazione e della
 * funzione repOk.
 */
public abstract class AbstractEntry implements Entry {
    private final String nome;

    /**
     * Inizializza una Entry di nome n.
     * 
     * @param n Nome della Entry.
     */
    public AbstractEntry(String n) {
        this.nome = n;
    }

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public abstract int dimensione();

    @Override
    public abstract Iterator<Entry> contenuto();

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AbstractEntry)){
            return false;
        }

        if(obj == this){
            return true;
        }

        AbstractEntry e = (AbstractEntry) obj;

        if(e.nome.equals(this.nome)){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public String toString(){
        String ret = String.format("%s", this.nome);

        return ret;
    }

    @Override
    public boolean repOk() {
        if(Objects.isNull(nome)){
            return false;
        }
        return true;
    }
}
