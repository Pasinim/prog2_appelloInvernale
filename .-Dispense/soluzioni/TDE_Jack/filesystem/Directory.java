package tde.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta una Directory, sottotipo di Entry caratterizzato da un nome,
 * dalla possibilitá di contenere al suo interno ulteriori Entry e da una
 * dimensione calcolata in base alle Entry che contiene.
 * 
 * Una Directory vuota ha dimensione 0.
 * 
 * Classe immutabile.
 * 
 * Una Directory ha la seguente funzione di astrazione: 
 *  AF(c) = super.toString + *
 * 
 * 
 * Una Directory deve avere un nome valido, quindi: r
 *  ep_inv = super.repOk()
 */
public class Directory extends AbstractEntry {
    private final List<Entry> entries;
    private int dimensione;
    
    /**
     * Inizializza una Directory con nome n vuota.
     * 
     * @param n Nome della Directory
     */
    public Directory(String n){
        super(n);
        this.entries = new ArrayList<>();
        this.dimensione = 0;

        if(!super.repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Inizializza una Directory con nome n e contenente tutte le Entry presenti in e.
     * 
     * @param n Nome della Directory.
     * @param e Lista di Entry da inserire in this.
     */
    public Directory(String n, List<Entry> e){
        super(n);

        if(Objects.isNull(e)){
            throw new IllegalArgumentException();
        }

        this.entries = new ArrayList<>(e);
        this.dimensione = 0;

        for (Entry entry : e) {
            this.dimensione += entry.getDimensione();
        }
    }

    /**
     * 
     * Ritorna una nuova Directory contentente la Entry e in input.
     * 
     * @return Nuovo Directory contenente e
     */
    public void aggiungiEntry(Entry e){
        entries.add(e);
    }

    @Override
    public int getDimensione(){
        return this.dimensione;
    }

    @Override
    public List<Entry> getContenuto(){
        return new ArrayList<>(entries);
    }

    @Override
    public String toString(){
        return super.toString() + "*";
    }

}
