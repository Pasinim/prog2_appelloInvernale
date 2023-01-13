import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;

//OVERVIEW: le istanze di questa classe permettono di rappresentare una mappa da stringhe ad interi. 
//Le istanze di questa classe sono mutabii 
public class Simplemap {
    //campi
    private List<String> keys;
    private List<Integer> values;
    /**
     * ABS FUN: AF(keys, values): è un insieme : {k_i, v_i | i=0, 1...keys.size(), k_i =keys[i] e v_i = values[i]}
     * REP INV: keys not null 
     *          values not null 
     *          i >= 0 
     *          keys  non contengono duplicaiti 
     *          keys.size() = values.size() 
     * ABS INV:
     *          a keys è associato solo un valore 
     *          le chiavi sono uniche   
     *          il numero di elementi k-> è maggiore o uguale a zero
     */
    //COSTRUTTORI
    //EFFECTS: inizializza una mappa vuota
    public Simplemap(){
        keys = new ArrayList<String>();
        values = new ArrayList<Integer>();
    }

     //Requires: k not null 
     //EFFECTS: se k non è presente nella mappa inserisce l'associazion k->v, altrimenti aggionra il valore v
     public void put(String k, int v){
        if (keys.indexOf(k) != -1) {
            keys.add(k);
            values.add(v);
        }else{
            int idx = keys.indexOf(k);
            values.add(v, idx);
        }
     }
     //Requires: k not null 
     //EFFECTS: se k è presente nella mappa restituisce true, false altrimenti
     public boolean contains(String k){
        return keys.contains(k);
     }

     public void remove(String k){}
     public int get(String k){
         if (keys.indexOf(k) == -1) throw new NoSuchElementException("Non presente");
         return values.get(keys.indexOf(k));
     }

     private boolean repOK(){
        return true;
     }

     @Override
     public String toString(){
         String str = "{ ";
         for (int i=0; i<keys.size(); i++)
            str +=  keys.get(i) + " : " + get(keys.get(i)) + " , ";
         return "}";
     }
}
