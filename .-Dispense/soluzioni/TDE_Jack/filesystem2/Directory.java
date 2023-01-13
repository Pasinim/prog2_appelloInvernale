package tde.filesystem2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Sottoclasse di AbstractEntry, rappresenta una Entry caratterizzata da un nome e dalla possibilitá di contenere zero, una o piú Entry al suo interno.
 * 
 * Classe mutabile.
 * 
 * Una Directory ha la seguente funzione d'astrazione:
 *  AF(c) = super.toString() + * 
 * Ed il seguente invariante:
 *  rep_inv = super.repOk()
 */
public class Directory extends AbstractEntry {
    private final List<Entry> entries;


    /**
     * Inizializza una Directory di nome n vuota.
     * 
     * @param n Nome della Directory.
     */
    public Directory(String n){
        super(n);
        this.entries = new ArrayList<>();

        if(!super.repOk()){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Aggiunge la Entry e a this.
     * 
     * Modifica lo stato di this.
     * 
     * @param e Entry
     */
    public void aggiungiEntry(Entry e){
        if(Objects.isNull(e)){
            throw new IllegalArgumentException();
        }
        entries.add(e);
    }

    /**
     * Ritorna puntatore, se presente, Entry di nome n
     * 
     * @throws NoSuchElementException Se la Entry non é presente.
     * @param n nome della Entry
     * @return Puntatore a Entry con nome n
     */
    public Entry getEntry(String n){
        for (Entry entry : entries) {
            if(entry.nome().equals(n)){
                return entry;
            }
        }
        throw new NoSuchElementException("Entry non presente");
    }

    @Override
    public int dimensione() {
        int dimensione = 0;

        for (Entry entry : entries) {
            dimensione += entry.dimensione();
        }

        return dimensione;
    }

    @Override
    public Iterator<Entry> contenuto() {
        return new contenutoGenerator(this.entries);
    }

    private class contenutoGenerator implements Iterator<Entry>{
        private final List<Entry> entries;
        private int pos;

        /**
         * Inizializza un generatore che lavora sulla lista e.
         * 
         * Il generatore sará in grado di iterare sugli elementi di e, nell'ordine con cui sono inseriti in e, senza modificare direttamente la struttura della lista.
         * Eventuali modifiche ad Entry mutabili presenti all'interno della List da parte del Client andranno a propagarsi anche all'interno di e.
         * 
         * @param e Lista su cui iterare.
         */
        public contenutoGenerator(List<Entry> e){
            this.entries = new ArrayList<>(e);
            this.pos = 0;
        }

		@Override
		public boolean hasNext() {
            if(this.pos < this.entries.size()){
                return true;
            }
            return false;
		}

		@Override
		public Entry next() {
            return this.entries.get(this.pos++);
		}
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Directory)){
            return false;
        }

        if(obj == this){
            return true;
        }

        Directory e = (Directory) obj;

        if(e.nome().equals(this.nome())){
            return true;
        }

        return false;
    }


    @Override
    public String toString(){
        String ret = String.format("%s*", super.toString());

        return ret;
    }
}
