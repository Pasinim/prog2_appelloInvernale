//package prog2.TDE_JACK.filesystem;

import java.util.List;

/**
 * Rappresenta un File, caratterizzato da un nome ed una dimensione validi.
 * 
 * Classe immutabile
 * 
 * Un File ha la seguente funzione d'astrazione:
 *  AF(c) = super.toString + (this.dimensione)
 * 
 * Dimensione e Nome del file devono essere validi, quindi:
 *  rep_inv: super.repOk() && this.dimensione > 0
 */
public class File extends AbstractEntry {
    private final int dimensione;

    /**
     * Inizializza un File con nome n e dimensione d.
     *  
     * Se l'invariante non viene rispettato viene sollevata una eccezione.
     * 
     * @param n Nome del File
     * @param d Dimensione del File
     */
    public File(String n, int d){
        super(n);
        this.dimensione = d;

        if(!repOk()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getDimensione() {
        return this.dimensione;
    }

    @Override
    public List<Entry> getContenuto() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Le entry File possono contenere ulteriori Entry");
    }

    @Override
    public String toString(){
        String ret = String.format("%s(%d)", super.toString(), this.dimensione);
        return ret;
    }

    @Override
    public boolean repOk() {
        if(!super.repOk()){
            return false;
        }

        if(this.dimensione <= 0){
            return false;
        }

        return true;
    }
    
}
