import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Le istanza di questa classe (concreta) implementano l'interfaccia StringMultiSet.
 * Un multiset è un insieme di elementi che possono avere al suo interno elementi ripetuti.
 * La molteplicità di un multiset è il numero di volte che un elemento compare al suo interno
 * la cardinalità di un multiset è la somma delle molteplicità dei suoi elementi
 * Il supporto di uun multiset è l'insieme (senza ripetizioni) dei suoi elementi
 * 
 * L'implementazione è stata realizzata mediante una HashMap che associa ad ogni stinga la propria molteplicità
 * 
 * AF: multiset != null
 *      ogni elemento del multiset != null
 *      il valore di ogni chiave >= 0
 * RI: 
 * 
 */

public class MapStringMS implements StringMultiSet{

    private final Map<String, Integer> multiset;
    
    /**
     * Instanzia un multiset vuoto
     */
    public MapStringMS() {
        multiset = new HashMap<String, Integer>();
    }

    @Override
    public int add(String s) {
        Objects.requireNonNull(s);
        if (s.isEmpty())
            throw new IllegalArgumentException("Impossibili aggiungere un elemento vuoto");
        if (this.contains(s))
            multiset.put(s, multiset.get(s) + 1);
        else 
            multiset.put(s, 1);
        return this.multiplicity(s);
    }

    @Override
    public int remove(String s) {
        int ret = this.multiplicity(s);
        Objects.requireNonNull(s);
        if (s.isEmpty())
            throw new IllegalArgumentException("Impossibili rimuovere un elemento vuoto");
        if (multiset.get(s) == 0) multiset.remove(s);
        multiset.put(s, multiset.get(s) - 1);
        if (this.multiplicity(s) < 0) throw new IllegalArgumentException("Errore: AF non rispettato");
        return ret;
    }

    @Override
    public boolean contains(String s) {
        Objects.requireNonNull(s);
        if (s.isEmpty())
            throw new IllegalArgumentException("Impossibile cercare un elemento vuoto");
        return multiset.containsKey(s);
    }

    @Override
    public int multiplicity(String s) {
        Objects.requireNonNull(s);
        try {
            if (!(this.contains(s)))
                return 0;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return multiset.get(s);
    }

    // default int size() {
    //     int size = 0;
    //     for (E e : this) size += multiplicity(e);
    //     return size;
    //   }

    @Override
    public int size() {
        Set<Entry<String, Integer>> els = multiset.entrySet();
        Iterator<Entry<String, Integer>> it = els.iterator();
        int ret = 0;
        while (it.hasNext()){
            Entry<String, Integer> curr = it.next();
            // System.out.println(String.format("it: K -> %s \t V -> %d", curr.getKey(), curr.getValue()));
            ret += curr.getValue();
        }
        return ret;
    }



    /**
    unione di due multiset A e B è il multiset U che ha per supporto l’unione
    dei supporti di A e B tale per cui la molteplicità di ciascuno elemento u in U
    è pari alla massima tra la molteplicità di u in A e in B

    Spiegazione: Non posso accedere alle chiavi dei multiset dato che l'iteratore restitusice solo la chiave.
    Per questo motivo devo prima iterare sul multiset this, prelevare la molteplicita ed aggiungere uno alla volta nel nuovo multiset
    finchè arrivo alla molteplicità corretta. Gli elementi di o che non sono contenuti in this vengono aggiounti
    con il secondo ciclo
     */
    @Override
    public StringMultiSet union(StringMultiSet o) {
        MapStringMS ret = new MapStringMS();
        Iterator<String> it = this.iterator();
        while (it.hasNext()){
            String curr = it.next();
            if (!o.contains(curr)) {
                for (int i = 0; i < this.multiplicity(curr); i++)
                    ret.add(curr); 
            }
            else{
                int mul = Math.max(this.multiplicity(curr), o.multiplicity(curr));
                for (int i = 0; i < mul; i++)
                    ret.add(curr);    
            }
        }
        Iterator<String> it_o = o.iterator();
        while (it_o.hasNext()){
            String curr = it_o.next();
            if (ret.contains(curr)) {
                continue;
            }
            else{
                ret.add(curr);
                for (int i = 0; i < o.multiplicity(curr) - 1; i++)
                    ret.add(curr);   
            }
        }
        return ret;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
       String ret = String.valueOf(this.size()) + " {";
       Iterator<String> it = this.iterator();
       while (it.hasNext()){
            String curr = it.next();
            ret += curr.toString() + ": " + this.multiplicity(curr) + ", ";
             
       } 
       return ret.substring(0, ret.length()-2) + "}";
        
    }


    /**
     * Restituisce un iteratore che itera sugli elemnenti del multiset (senza ripetizioni)
     */
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private final Iterator<String> it = multiset.keySet().iterator();
            // private final Set<String> elements = new HashSet<String>();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public String next() {
                return it.next();
            }
        };
    }

    
}
