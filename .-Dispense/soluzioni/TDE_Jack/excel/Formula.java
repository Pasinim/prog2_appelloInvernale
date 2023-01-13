package tde.excel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Classe sottotipo di Contenuto il cui valore viene calcolato sulla base delle Formule ed il valore contenuto nelle Celle a cui tali Formule si riferiscono.
 * 
  * Classe immutabile.

 * La funzione d'astrazione di Formula puó essere definita come:
 *  AF(c) = this.operazione +
 *          Per ogni Cella c riferita da Formula -> c.toString()
 * 
 * Una Formula si riferisce ad un insieme di Celle non nullo su cui esegue una Operazione valida, quindi:
 *  rep_inv = this.celle not null && this.operazione not null
 */
public class Formula extends Contenuto {
    //private final List<Integer> celle;
    private Map<Cella, Integer> cache;
    private final Operazione operazione;

    /**
     * Inizializza una Formula avente un valore calcolato sulla base del valore contenuto nelle celle in c calcolandolo
     * tramite l'operazione o.
     * 
     * Il valore viene calcolato sulla base dell'oridine con cui le Celle sono in c, di conseguenza nel caso di Operazioni non
     * associative il valore di this varierá sulla base di tale ordine.
     * 
     * @param c Celle a cui la Formula si riferisce.
     * @param o Operazione da applicare alle relative Celle.
     */
    public Formula(List<Cella> c, Operazione o){
        this.operazione = o;
        this.cache = new LinkedHashMap<>();

        for (Cella cella : c) {
            cache.put(cella, cella.getValore());
            
        }

        if(!repOk()){
            throw new IllegalArgumentException();
        }

        propagaAggiornamento();
    }

    /**
     * Aggiorna il valore della cache relativo a c.
     * 
     * @param c Cella di cui aggiornare il valore
     * @param v Nuovo valore di c.
     */
    public void aggiornaCache(Cella c, int v){
        cache.put(c,v);
    }


    private void propagaAggiornamento(){
        Set<Cella> c = cache.keySet();

        for (Cella cella : c) {
            cella.aggiungiFormula(this);
        }
    }
    

    @Override
    public int getValore() {
        // List<Integer> valori = new ArrayList<>();

        // for (Cella c : celle) {
        //     valori.add(c.getValore());
        // }
        Collection<Integer> c = cache.values();
        List<Integer> valori = new ArrayList<>(c);

        return operazione.calcola(valori);
    }

    @Override
    public boolean equals(Object o) {
        // Due Formule f1,f2 sono equivalenti sse f1 == f2
        if(o == this){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        
        return 0;
    }

    @Override
    public boolean repOk() {
        if(Objects.isNull(this.cache) || Objects.isNull(this.operazione)){
            return false;
        }
        return true;
    }
    
}
