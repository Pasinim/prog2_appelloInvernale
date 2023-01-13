package tde.bancarelle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe mutabile Inventario.
 * 
 * Rappresenta un Inventario, caratterizzato da una collezione di Giocattoli.
 * 
 * Una tipica istanza di Inventario puó essere rappresentata tramite la seguente funzione d'astrazione:
 *  AF(c) = perOgni Giocattolo g: g.quantita + g.toString().
 */
public class Inventario {
    private Map<Giocattolo, Integer> inventario;

    /**
     * Inizializza un Inventario vuoto.
     */
    public Inventario(){
        inventario = new HashMap<>();
    }

    /**
     * Inizializza un Inventario data una lista di Giocattoli g.
     * 
     * @param g Lista di Giocattolo
     */
    public Inventario(List<Giocattolo> g){
        inventario = new HashMap<>();

        this.aggiungi(g);
    }

    /**
     * Restituisce quantita di g presente in this.
     * 
     * Se g non é presente viene sollevata un'eccezione.
     * 
     * @param g Giocattolo.
     * @return Quantita di g in this.
     */
    public int getQuantita(Giocattolo g){
        if(!(inventario.containsKey(g))){
            throw new IllegalArgumentException();
        }

        return this.inventario.get(g);
    }

    /**
     * Ritorna Iteratore che permette di iterare su tutti i Giocattoli presenti in this.
     * 
     * @return Iteratore
     */
    public Iterator<Giocattolo> giocattoli(){
        return new giocattoliGenerator(inventario);
    }

    /**
     * Implementa un Iteratore per la classe.
     */
    private class giocattoliGenerator implements Iterator<Giocattolo>{
        private Map<Giocattolo, Integer> inv;
        private Set<Map.Entry<Giocattolo, Integer>> ent;
        private Iterator<Map.Entry<Giocattolo, Integer>> i;

        public giocattoliGenerator(Map<Giocattolo, Integer> m){
            inv = new HashMap<>(m);
            ent = inv.entrySet();
            i = ent.iterator();
        }

        @Override
        public boolean hasNext() {
            if(i.hasNext()){
                return true;
            }
            return false;
        }

        @Override
        public Giocattolo next() {
            return i.next().getKey();
        }
        
    }

    /**
     * Aggiunge un Giocattolo g a this.
     * 
     * Se g é giá presente la sua quantitá viene aumentata di 1.
     * 
     * @param g Giocattolo da aggiungere
     */
    public void aggiungi(Giocattolo g){
        inventario.computeIfPresent(g, (key,val) -> val += 1); 
        inventario.computeIfAbsent(g, (key) ->  1);
    }

    /**
     * Aggiunge una lista di Giocattoli g all'inventario.
     * 
     * Per ogni Giocattolo x in g: Se x é giá presente la sua quantitá viene aumentata di 1.
     * 
     * @param g Lista di Giocattoli.
     */
    public void aggiungi(List<Giocattolo> g){
        for (Giocattolo giocattolo : g) {
            inventario.computeIfPresent(giocattolo, (key,val) -> val += 1);
            inventario.computeIfAbsent(giocattolo, (key) ->  1);
        }
    }

    /**
     * Rimuove il Giocattolo g dall'Inventario.
     * 
     * Se g non é presente viene sollevata un'eccezione
     * 
     * @param g Giocattolo da rimuovere
     */
    public void rimuovi(Giocattolo g){
        if(!(inventario.containsKey(g))){
            throw new IllegalArgumentException();
        }

        inventario.remove(g);
    }
    
    /**
     * Rimuove una quantitá q del Giocattolo g dall'Inventario.
     * Se la quantitá dopo la rimozione é pari a 0 il Giocattolo viene rimosso da this.
     * 
     * Se g non é presente o é presente in quantitá minore di q viene sollevata un'eccezione.
     * 
     * @throws IllegalArgumentException Se la quantitá non é sufficiente.
     * @param g Giocattolo da rimuovere
     */
    public void rimuovi(Giocattolo g, int q){
        if(!(inventario.containsKey(g)) || q > inventario.get(g)){
            throw new IllegalArgumentException();
        }

        inventario.computeIfPresent(g, (key,val) -> val -= q);

        if(inventario.get(g) == 0){
            inventario.remove(g);
        }
    }

    @Override
    /**
     * Ritorna stringa rappresentante stato di this.
     * 
     * @return String AF.
     */
    public String toString(){
        return inventario.toString();
    }
}
