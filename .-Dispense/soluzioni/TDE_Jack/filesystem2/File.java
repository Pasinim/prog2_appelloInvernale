package tde.filesystem2;

import java.util.Iterator;

/**
 * Sottoclasse di AbstractEntry, rappresenta una Entry caratterizzata da un nome ed un dimensione validi,
 * non é in grado di contenere ulteriori Entry.
 * 
 * Classe immutabile.
 * 
 * Un File ha la seguente funzione d'astrazione:
 *  AF(c) = this.nome(this.dimensione)
 * Ed il seguente invariante:
 *  rep_inv = super.repOk() && this.dimensione > 0
 */
public class File extends AbstractEntry {
    private final int dimensione;

    /**
     * Inizializza un file di dimensione d e nome n.
     * 
     * @param n Nome del file
     * @param d Dimensione del file
     */
    public File(String n, int d){
        super(n);
        this.dimensione = d;

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int dimensione() {
        return this.dimensione;
    }

    @Override
    public Iterator<Entry> contenuto() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof File)){
            return false;
        }

        if(obj == this){
            return true;
        }

        File e = (File) obj;

        if(e.nome().equals(this.nome())){
            return true;
        }

        return false;
    }

    @Override 
    public String toString(){
        String ret = String.format("%s(%d)", super.toString(), this.dimensione);

        return ret;
    }

    @Override
    public boolean repOk(){
        if(!super.repOk() || this.dimensione <= 0){
            return false;
        }
        return true;
    }
    
}
