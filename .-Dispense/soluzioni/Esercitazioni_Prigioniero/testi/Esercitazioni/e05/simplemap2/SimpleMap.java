import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
/**
 * OVERVIEW: Le istanze di questa classe permettono di rappresentare una mappa da stringhe ad interi
 *      Una mappa tipica è {k1:v1, k2:v2,..., kn:vn} in cui le chiavi sono uniche
 *      pertanto per ogni i: ki != kj se i!=j
 * 
 *      A seguito dell'aggiunta di un elemento k -> v
 *      La mappa {k1:v1, k2:v2,..., kn:vn} risulterà {k1:v1, k2:v2, k:v ,..., kn:vn} se k è già presente
 *      {k1:v1, k2:v2,..., kn:vn, k:v} altrimenti
 */
public class SimpleMap {
    //ATTRIBUTI
    //variabile di istanza che rappresenta la lista di chiavi
    private List<String> keys;
    //v istanza che rappresenta la lista di valori associati alle chiavi
    private List<Integer> vals;
/**
 * ABS FUN: //AF(keys, val) -> {keys_1 : vals_1, ..., keys_n : vals_n} -> più specifico, cosa sono keys_1 e vals_1??
 *          AF(keys, val)
 * dove keys_i è univoco per ogni i -> NON LO DEVO DIRE IN AF, devo solo dire come si traduce l'astrazione in "versione java"
 * 
 * REP INV: keys e vals != null 
 *          keys e vals non contengono riferimenti null 
 *          keys.size = vals.size 
 *          keys_i univoco, non contiene elementi ripetuti
 * 
 * ABS INV: le chiavi sono univoche 
 *          ad ogni chiave corrisponde uno e un solo elemento 
 *          numero di associazioni >= 0
 * 
 */

    //COSTRUTTORI   
    /**
     * Corretteza AF: AF(keys, vals) = {}
     * 
     * Preservamento RI: Keys e vals non contengono nessun elemento, quindi non possono avere riferimenti nulli 
     *                  inizializzo la mappa, quindi non sono nulli 
     *                  size = 0
     *                  vuoto, quindi non ci sono elementi ripetuti
     * 
     * Preservamento AI:    size = 0
     * 
     */
    //EFFECTS: inizializza una mappa vuota
    public SimpleMap (){
        keys = new ArrayList<>();
        vals = new ArrayList<>();
    }

    //METODI
    /**
     * Correttezza AF: assumo di avere {k1 : v1, k2 : v2, ... , kn : vn } e di aggiungere el e val_el 
     *                  se el non è presente -> {k1 : v1, k2 : v2, ... , kn : vn, el : val_el }
     *                  se è presente -> {k1 : v1, k2 : v2 : val_el, ... , kn : vn }  
     * Preservamento RI: se keys è null viene sollevata un eccezione 
     *                  se k è presente size è invariato, altrimenti size + 1
     * Preservamento AI: se la chiave è già presente viene aggiornato
     *                   se la chiave è già presente size non viene aggiornato altrimenti size + 1
     * 
     * Modifies: this 
     * Effects: se k non è  presente nella mappa inserisce  l'associazione k -> v. Altrienti aggiorna il valore v associato a k
     * 
     */
    public void put(String k, int v){
        Objects.requireNonNull(k, "k must be not null");
        int idx = this.getIdx(k);
        if (idx != -1) //se k è già presente
            vals.set(idx, v); 
        else{
            keys.add(k);
            vals.add(v); 
        }
        return;

    };

     /**
     * Correttezza AF: Se prima la mappa era corretta e rimuovo el
     *                  {k1 : v1, k2 : v2, ... el : val_el, kn : vn } -> remove(el) -> {k1 : v1, k2 : v2, ...,  kn : vn } 
     * Preservamento RI: Assumo che prima del metodo remvoe gli elementi non erano null. In seguito alla rimozione 
     *                  non ci sarà quindi nessun elemento null 
     *                  size = size - 1 
     * Preservamento AI: size = size - 1 
     * Effects: rimove l'elementro di chiave k dalla mappa. Se k non è presente non fa nulla
     */
    
    public void remove(String k){
        int idx = this.getIdx(k); 
        if ( idx == -1 ) return;
        keys.remove(idx);
        vals.remove(idx);
        return;
    };
/**
 * REQUIRES: k presente nella lista
 * EFFECTS; restiuisce il valore associato alla chiave k 
 */

    public int get(String k){
        int idx = this.getIdx(k); 
        return vals.get(idx);
    };

    //EFFECTS: restituisce la posizione di keys. Se non è presente ritorna -1
    public int getIdx(String k){
        if (!keys.contains(k)) return -1;
        return keys.indexOf(k);
    }

    @Override 
    public String toString(){
        String str = "{";
        for (int i=0; i < keys.size() - 1; i++)
            str += "\t" + keys.get(i) + " : " + vals.get(i) + "\n";
        return str += "\t" + keys.get(keys.size() - 1) + " : " + vals.get(keys.size() - 1) + "\t}";
    }

    public boolean equals (Object o){
        if (!(o instanceof SimpleMap)) return false;

        SimpleMap other = (SimpleMap) o;
        if (this.keys.size() != other.keys.size()) return false; 
        for (int i=0; i<this.keys.size(); i++) {
            if ((this.keys.get(i) != other.keys.get(i)) && (this.vals.get(i) != other.vals.get(i))) 
                return false;
        }
        return true;
    }


        /**
     * Correttezza AF:
     * Preservamento RI:
     * Preservamento AI:
     */
    
}
