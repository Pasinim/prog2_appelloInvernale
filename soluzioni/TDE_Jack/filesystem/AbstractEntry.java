//package tde.filesystem;

import java.util.Objects;

/**
 * Fornisce ulteriori dettagli implementativi per l'interfaccia Entry.
 */
public abstract class AbstractEntry implements Entry{
    private final String nome;

    /**
     * Inizializza una Entry avente nome n.
     * 
     * Se la String in input é nulla viene sollevata una eccezione.
     * 
     * @param n Nome della Entry.
     */
    public AbstractEntry(String n){
        this.nome = n;
    }

    @Override
    public String getNome(){
        return nome;
    }

    @Override 
    public String toString(){
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Entry)){
            return false;
        }

        if(obj == this){
            return true;
        } 

        Entry e = (Entry) obj;
        if(e.getNome().equals(this.getNome())){
            return true;
        }

        return false;
    }

    @Override 
    public boolean repOk(){
        if(Objects.isNull(nome)){
            return false;
        }
        return true;
    }
}
